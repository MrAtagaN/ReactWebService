package com.plekhanov.react_web_service.dao.impl;

import com.plekhanov.react_web_service.dao.ProductTypeDao;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.entities.ProductType.Gender;
import com.plekhanov.react_web_service.entities.ProductType.Age;
import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.search_params.ProductTypeSearchParams;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.springframework.dao.support.DataAccessUtils.singleResult;

@Slf4j
@RequiredArgsConstructor
@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class ProductTypeDaoImpl implements ProductTypeDao {

    EntityManager entityManager;


    @Override
    public ProductType findByParameters(final String name, final Gender gender, final Age age, final Category category) {
        try (Session session = entityManager.unwrap(Session.class)) {
            final Query<ProductType> query =
                    session.createQuery("FROM ProductType p " +
                            "WHERE p.category = :category AND p.name = :name AND p.gender = :gender AND p.age = :age", ProductType.class);
            query.setParameter("category", category);
            query.setParameter("gender", gender);
            query.setParameter("age", age);
            query.setParameter("name", name);
            return singleResult(query.list());
        } catch (Exception e) {
            log.error("Error while findByCategory ProductType: {}", e.getMessage());
            throw e;
        }
    }


    @Override
    public Set<ProductType> search(final ProductTypeSearchParams productTypeSearchParams) {

        try (Session session = entityManager.unwrap(Session.class)) {
            final Map<String, Object> params = new HashMap<>();
            final StringBuilder stringQuery = new StringBuilder("FROM ProductType p WHERE 1=1");

            final String name = productTypeSearchParams.getName();
            if (name != null) {
                stringQuery.append(" and p.name = :name");
                params.put("name", name);
            }
            final Gender gender = productTypeSearchParams.getGender();
            if (gender != null) {
                stringQuery.append(" and p.gender = :gender");
                params.put("gender", gender);
            }
            final Age age = productTypeSearchParams.getAge();
            if (age != null) {
                stringQuery.append(" and p.age = :age");
                params.put("age", age);
            }
            final Category category = productTypeSearchParams.getCategory();
            if (category != null) {
                stringQuery.append(" and p.category = :category");
                params.put("category", category);
            }

            final Query<ProductType> query = session.createQuery(stringQuery.toString(), ProductType.class);
            query.setProperties(params);

            return new HashSet<>(query.list());
        } catch (Exception e) {
            log.error("Error while findByCategory ProductType: {}", e.getMessage());
            throw e;
        }
    }


    @Override
    public void delete(final int id) {
        try (Session session = entityManager.unwrap(Session.class)) {
            final ProductType productType = session.load(ProductType.class, id);
            session.delete(productType);
        } catch (Exception e) {
            log.error("Error while delete ProductType, id: {}, {}", id, e.getMessage());
            throw e;
        }
    }


    @Override
    public ProductType saveOrUpdate(final ProductType productType) {
        try (Session session = entityManager.unwrap(Session.class)) {
            final ProductType savedProductType = (ProductType) session.merge(productType);
            return savedProductType;
        } catch (Exception e) {
            log.error("Error while save ProductType, {}", e.getMessage());
            throw e;
        }
    }
}
