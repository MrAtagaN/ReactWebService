package com.plekhanov.react_web_service.dao.impl;

import com.plekhanov.react_web_service.dao.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.plekhanov.react_web_service.entities.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {

    final SessionFactory sessionFactory;

    public User findByName(final String username) {
        List<User> result;
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User u where u.username = :username", User.class);
            query.setParameter("username", username);
            result = query.list();
            return result.get(0); //TODO;
        }
    }
}
