package com.plekhanov.react_web_service.dao.impl;

import com.plekhanov.react_web_service.dao.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import com.plekhanov.react_web_service.entities.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    public User findById(final Integer id){
        try (Session session = sessionFactory.openSession()) {
            return session.find(User.class, id);
        }
    }

    public List<User> findByName(final String username) {
        try (Session session = sessionFactory.openSession()) {
            final Query<User> query = session.createQuery("FROM User u where u.username = :username", User.class);
            query.setParameter("username", username);
            return query.list();
        }
    }

    public User findByEmail(final String email) {
        try (Session session = sessionFactory.openSession()) {
            final Query<User> query = session.createQuery("FROM User u where u.email = :email", User.class);
            query.setParameter("email", email);
            return DataAccessUtils.singleResult(query.list());
        }
    }
}
