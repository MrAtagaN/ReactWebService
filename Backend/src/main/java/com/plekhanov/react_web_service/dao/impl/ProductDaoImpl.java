package com.plekhanov.react_web_service.dao.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.Product.Category;
import com.plekhanov.react_web_service.entities.Product.Age;
import com.plekhanov.react_web_service.entities.Product.Gender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Repository
public class ProductDaoImpl implements ProductDao {

    private final SessionFactory sessionFactory;

    private final String SELECT_TYPES_BY_PARAMETERS_QUERY =
            "select distinct p.type FROM Product p " +
            "   where " +
            "       p.category = :category and " +
            "       p.age = :age and " +
            "       p.gender = :gender";

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
    public Set<String> getTypesByParameters(Category category, Age age, Gender gender) {
        try (Session session = sessionFactory.openSession()) {
            Map<String, Object> params = new HashMap<>();
            params.put("category", category);
            StringBuilder stringQuery = new StringBuilder("select distinct p.type FROM Product p where p.category = :category");

            if (age != null) {
                stringQuery.append(" and p.age = :age");
                params.put("age", age);
            }
            if (gender != null) {
                stringQuery.append(" and p.gender = :gender");
                params.put("gender", gender);
            }

            final Query<String> query = session.createQuery(stringQuery.toString(), String.class);
            query.setProperties(params);
            return new HashSet<>(query.list()) ;
        }
    }
}
