package com.plekhanov.react_web_service.dao.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.Product.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Repository
public class ProductDaoImpl implements ProductDao {

    private final SessionFactory sessionFactory;

    @Override
    public Product findById(final int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Product.class, id);
        }
    }

    @Override
    public Integer save(final Product product) {
        Integer id = null;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            id = (Integer) session.save(product);
            transaction.commit();
        } catch (Exception e) {
            log.error("Error while save Product", e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return id;
    }

    @Override
    public Set<String> getTypesByCategory(Category category) {
        try (Session session = sessionFactory.openSession()) {
            final Query<String> query = session.createQuery("select distinct p.type FROM Product p where p.category = :category", String.class);
            query.setParameter("category", category);
            return new HashSet<>(query.list()) ;
        }
    }
}
