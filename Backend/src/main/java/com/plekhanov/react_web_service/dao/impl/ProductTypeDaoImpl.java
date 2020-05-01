package com.plekhanov.react_web_service.dao.impl;

import com.plekhanov.react_web_service.dao.ProductTypeDao;
import com.plekhanov.react_web_service.entities.ProductType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

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
        }
    }
}
