package com.plekhanov.react_web_service.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @Test
    void saveOrUpdate() {
        userDao.findByName("asd");
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findByEmail() {
    }
}
