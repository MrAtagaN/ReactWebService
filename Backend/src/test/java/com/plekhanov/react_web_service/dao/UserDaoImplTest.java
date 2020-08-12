package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @DisplayName("положительный saveOrUpdate")
    @Test
    void saveOrUpdate() {
    }

    @Test
    void findById() {
        userDao.findByEmail("sx");
    }

    @Test
    void findByName() {
    }

    @Test
    void findByEmail() {
    }
}
