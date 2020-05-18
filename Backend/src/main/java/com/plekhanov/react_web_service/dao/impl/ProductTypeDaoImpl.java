package com.plekhanov.react_web_service.dao.impl;

import com.plekhanov.react_web_service.dao.ProductTypeDao;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.entities.ProductType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.dao.support.DataAccessUtils.singleResult;

@Slf4j
@RequiredArgsConstructor
@Repository
public class ProductTypeDaoImpl implements ProductTypeDao {

    private final SessionFactory sessionFactory;

    @Override
    public Set<ProductType> getAll() {
        try (Session session = sessionFactory.openSession()) {
            final Query<ProductType> query = session.createQuery("FROM ProductType p", ProductType.class);
            return new HashSet<>(query.list());
        } catch (Exception e) {
            log.error("Error while getAll ProductType: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public ProductType findByNameAndCategory(final String name, final Category category) {
        try (Session session = sessionFactory.openSession()) {
            final Query<ProductType> query =
                    session.createQuery("FROM ProductType p WHERE p.category = :category AND p.name = :name", ProductType.class);
            query.setParameter("category", category);
            query.setParameter("name", name);
            return singleResult(query.list());
        } catch (Exception e) {
            log.error("Error while findByCategory ProductType: {}", e.getMessage());
            throw e;
        }
    }


    @Override
    public Set<ProductType> findByCategory(final Category category) {
        try (Session session = sessionFactory.openSession()) {
            final Query<ProductType> query =
                    session.createQuery("FROM ProductType p WHERE p.category = :category", ProductType.class);
            query.setParameter("category", category);
            return new HashSet<>(query.list());
        } catch (Exception e) {
            log.error("Error while findByCategory ProductType: {}", e.getMessage());
            throw e;
        }
    }


    @Override
    public void delete(final int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            final ProductType productType = session.load(ProductType.class, id);
            session.delete(productType);
            transaction.commit();
        } catch (Exception e) {
            log.error("Error while delete ProductType, id: {}, {}", id, e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }


    @Override
    public ProductType saveOrUpdate(final ProductType productType) {
        ProductType savedProductType;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            savedProductType = (ProductType) session.merge(productType);
            transaction.commit();
        } catch (Exception e) {
            log.error("Error while save ProductType, {}", e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
        return savedProductType;
    }
}
