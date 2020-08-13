package com.plekhanov.react_web_service.dao;


import com.plekhanov.react_web_service.entities.User;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach()
    public void init() {

    }

    @Test
    void saveOrUpdate() {

    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
        //jdbcTemplate.update("INSERT INTO public.users (username, email) VALUES ('Sergey', 'gmail@plekhanov.ru')");
        List<User> found = userDao.findByName("Sergey");
        assertEquals(found.size(), 1);
    }

    @Test
    void findByEmail() {
        User found = userDao.findByEmail("gmail@plekhanov.ru");
        assertNotNull(found);
    }
}
