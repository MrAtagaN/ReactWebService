package com.plekhanov.react_web_service.uploaders;

import com.plekhanov.react_web_service.model.entities.User;
import com.plekhanov.react_web_service.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.plekhanov.react_web_service.config.security.Authority.ADMIN;
import static com.plekhanov.react_web_service.config.security.Authority.USER;
import static java.util.Collections.singleton;

/**
 * Загрузка в базу тестовых {@link User}
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserUploader {

    UserService userService;
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public void uploadData() {
        //admin@gmail.com
        User admin = userService.findByEmail("admin@gmail.com");
        if (admin == null) {
            admin = new User();
            admin.setUsername("Сергей");
            admin.setPassword(bCryptPasswordEncoder.encode("admin"));
            admin.setAuthorities(singleton(ADMIN));
            admin.setAccountNonExpired(true);
            admin.setAccountNonLocked(true);
            admin.setCredentialsNonExpired(true);
            admin.setEnabled(true);
            admin.setEnter(LocalDateTime.of(2019, 11, 10, 9, 12));
            admin.setCreationTime(LocalDateTime.of(1989, 12, 24, 9, 12));
            admin.setEmail("admin@gmail.com");
            userService.saveOrUpdate(admin);
        }

        //user@gmail.com
        User user = userService.findByEmail("user@gmail.com");
        if (user == null) {
            user = new User();
            user.setUsername("Александр");
            user.setPassword(bCryptPasswordEncoder.encode("user"));
            user.setAuthorities(singleton(USER));
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setEnter(LocalDateTime.of(2019, 12, 24, 9, 12));
            user.setCreationTime(LocalDateTime.of(1989, 12, 24, 9, 12));
            user.setEmail("user@gmail.com");
            userService.saveOrUpdate(user);
        }
    }

}
