package com.plekhanov.react_web_service.uploaders;

import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.model.entities.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.plekhanov.react_web_service.model.entities.Authority.ADMIN;
import static com.plekhanov.react_web_service.model.entities.Authority.USER;
import static java.util.Collections.singleton;

/**
 * Загрузка в базу тестовых {@link User}
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserUploader {

    UserDao userDao;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public void uploadData() {
        userDao.deleteAll();

        //admin@gmail.com
        User admin = new User();
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
        userDao.save(admin);


        //user@gmail.com
        User user = new User();
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
        userDao.save(user);

    }

}
