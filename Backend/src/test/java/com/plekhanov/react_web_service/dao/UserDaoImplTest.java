package com.plekhanov.react_web_service.dao;


import com.plekhanov.react_web_service.entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @BeforeAll
    public void initDB() {
            User user = new User();
            user.setUsername("Sergey");
            user.setEmail("gmail@plekhanov.ru");
            user.setPassword("12345678");
            user.setCreationTime(LocalDateTime.now());
            userDao.save(user);
    }


    @Test
    void saveOrUpdate() {

    }

    @Test
    void findById() {
    }

    @DisplayName("положительный findByUsername")
    @Test
    void positiveFindByNameTest() {
        //jdbcTemplate.update("INSERT INTO public.users (username, email) VALUES ('Sergey', 'gmail@plekhanov.ru')");
        List<User> found = userDao.findByUsername("Sergey");
        assertEquals(1, found.size());
        assertEquals("Sergey", found.get(0).getUsername());
    }

    @DisplayName("отрицательный findByUsername")
    @Test
    void negativeFindByNameTest() {
        //jdbcTemplate.update("INSERT INTO public.users (username, email) VALUES ('Sergey', 'gmail@plekhanov.ru')");
        List<User> found = userDao.findByUsername("Max");
        assertEquals(0, found.size());
    }

    @Test
    void findByEmail() {
        User found = userDao.findByEmail("gmail@plekhanov.ru");
        assertNotNull(found);
        assertEquals("gmail@plekhanov.ru", found.getEmail());
    }
}
