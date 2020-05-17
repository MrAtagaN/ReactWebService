package com.plekhanov.react_web_service.demo_data_uploader.impl.uploaders;

import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.plekhanov.react_web_service.web.security.Role.ADMIN;
import static com.plekhanov.react_web_service.web.security.Role.USER;
import static java.util.Collections.singleton;

/**
 * Загрузка в базу {@link User}
 */
@Service
@RequiredArgsConstructor
public class UserUploader {

    private final UserService userService;


    public void insertData() {
        User admin = userService.findByEmail("admin@gmail.com");
        if (admin == null) {
            admin = new User();
            admin.setUsername("Сергей");
            admin.setPassword("$2a$10$nWq3jS4Xui7hMVz4L1dUVuRYzY8DQsfWUROmXA627yd.wjm/FrD5G"); //admin
            admin.setAuthorities(singleton(ADMIN));
            admin.setAccountNonExpired(true);
            admin.setAccountNonLocked(true);
            admin.setCredentialsNonExpired(true);
            admin.setEnabled(true);
            admin.setEnter(LocalDateTime.of(2019,11,10,9,12));
            admin.setCreationTime(LocalDateTime.of(1989,12,24,9,12));
            admin.setEmail("admin@gmail.com");
            userService.saveOrUpdate(admin);
        }

        User user = userService.findByEmail("user@gmail.com");
        if (user == null) {
            user = new User();
            user.setUsername("Александр");
            user.setPassword("$2a$10$DPPNZFtJEqmVr8qpARZfvu4HbT2Sd1bj563TIgZ35A7JPVtZUZ5MG"); //user
            user.setAuthorities(singleton(USER));
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setEnter(LocalDateTime.of(2019,12,24,9,12));
            user.setCreationTime(LocalDateTime.of(1989,12,24,9,12));
            user.setEmail("user@gmail.com");
            userService.saveOrUpdate(user);
        }
    }

}
