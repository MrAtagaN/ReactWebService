package com.plekhanov.react_web_service.dao.impl;

import com.plekhanov.react_web_service.dao.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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


    @Override
    public User saveOrUpdate(final User user) {
        User savedUsed;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            savedUsed = (User) session.merge(user);
            transaction.commit();
        } catch (Exception e) {
            log.error("Error while save User");
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
        return savedUsed;
    }


    public User findById(final int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(User.class, id);
        } catch (Exception e) {
            log.error("Error while findById User, id: {}", id);
            throw e;
        }
    }

    public List<User> findByName(final String username) {
        try (Session session = sessionFactory.openSession()) {
            final Query<User> query = session.createQuery("FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", username);
            return query.list();
        } catch (Exception e) {
            log.error("Error while findByName User, username: {}", username);
            throw e;
        }
    }

    public User findByEmail(final String email) {
        try (Session session = sessionFactory.openSession()) {
            final Query<User> query = session.createQuery("FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            return DataAccessUtils.singleResult(query.list());
        } catch (Exception e) {
            log.error("Error while findByEmail User, email: {}", email);
            throw e;
        }
    }
}
