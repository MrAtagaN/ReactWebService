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
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
        try {
            final TypedQuery<ProductType> query =
                    entityManager.createQuery("FROM ProductType p " +
                            "WHERE p.category = :category AND p.name = :name AND p.gender = :gender AND p.age = :age", ProductType.class);
            query.setParameter("category", category);
            query.setParameter("gender", gender);
            query.setParameter("age", age);
            query.setParameter("name", name);
            return query.getSingleResult();
        } catch (Exception e) {
            log.error("Error while findByCategory ProductType: {}", e.getMessage());
            throw e;
        }
    }


    @Override
    public Set<ProductType> search(final ProductTypeSearchParams productTypeSearchParams) {

        try {
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

            final TypedQuery<ProductType> query = entityManager.createQuery(stringQuery.toString(), ProductType.class);
            params.forEach(query::setParameter);

            return new HashSet<>(query.getResultList());
        } catch (Exception e) {
            log.error("Error while findByCategory ProductType: {}", e.getMessage());
            throw e;
        }
    }


    @Override
    public void delete(final int id) {
        try {
            final ProductType productType = entityManager.find(ProductType.class, id);
            entityManager.remove(productType);
        } catch (Exception e) {
            log.error("Error while delete ProductType, id: {}, {}", id, e.getMessage());
            throw e;
        }
    }


    @Override
    public ProductType saveOrUpdate(final ProductType productType) {
        try {
            return entityManager.merge(productType);
        } catch (Exception e) {
            log.error("Error while save ProductType, {}", e.getMessage());
            throw e;
        }
    }
}
