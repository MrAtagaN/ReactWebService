package com.plekhanov.react_web_service.dao.impl;

import com.plekhanov.react_web_service.dao.UserDao;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import com.plekhanov.react_web_service.entities.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class UserDaoImpl implements UserDao {

    EntityManager entityManager;


    @Override
    public User saveOrUpdate(final User user) {
        try (Session session = entityManager.unwrap(Session.class)) {
            return (User) session.merge(user);
        } catch (Exception e) {
            log.error("Error while save User: {}", e.getMessage());
            throw e;
        }
    }


    public User findById(final int id) {
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.find(User.class, id);
        } catch (Exception e) {
            log.error("Error while findById User, id: {}, {}", id, e.getMessage());
            throw e;
        }
    }

    public List<User> findByName(final String username) {
        try (Session session = entityManager.unwrap(Session.class)) {
            final Query<User> query = session.createQuery("FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", username);
            return query.list();
        } catch (Exception e) {
            log.error("Error while findByName User, username: {}, {}", username, e.getMessage());
            throw e;
        }
    }

    public User findByEmail(final String email) {
        try (Session session = entityManager.unwrap(Session.class)) {
            final Query<User> query = session.createQuery("FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            return DataAccessUtils.singleResult(query.list());
        } catch (Exception e) {
            log.error("Error while findByEmail User, email: {}, {}", email, e.getMessage());
            throw e;
        }
    }
}
