package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.config.security.Authority;
import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.dao.UserRegistrationDao;
import com.plekhanov.react_web_service.exceptions.ConfirmCodeException;
import com.plekhanov.react_web_service.exceptions.UserEmailAlreadyExist;
import com.plekhanov.react_web_service.exceptions.UserRequestTimeOutException;
import com.plekhanov.react_web_service.services.MailSender;
import com.plekhanov.react_web_service.services.UserRegistrationService;
import com.plekhanov.react_web_service.entities.UserRegistrationRequest;
import com.plekhanov.react_web_service.entities.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Создание нового пользователя через email
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserEmailRegistrationService implements UserRegistrationService {

    UserRegistrationDao userRegistrationDao;
    MailSender mailSender;
    UserDao userDao;

    /**
     * Создает в базе запись {@link UserRegistrationRequest}, посылает на почту код для подтверждения email
     */
    @Override
    @Transactional
    public void userRegistrationRequest(final String username, final String email, final String password) {
        final UserRegistrationRequest found = userRegistrationDao.findByEmail(email);
        if (found != null) {
            throw new UserEmailAlreadyExist("Пользователь с таким email уже существует");
        }
        final User user = userDao.findByEmail(email);
        if (user != null) {
            throw new UserEmailAlreadyExist("Пользователь с таким email уже существует");
        }
        final UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setEmail(email);
        userRegistrationRequest.setPassword(password);
        userRegistrationRequest.setUsername(username);
        final String confirmCode = String.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000)); //TODO вынести в параметр
        userRegistrationRequest.setConfirmCode(confirmCode);
        userRegistrationRequest.setCreationTime(LocalDateTime.now());
        userRegistrationDao.save(userRegistrationRequest);
        mailSender.sendUserRegistrationConfirmCodeMail(email, confirmCode);
    }


    /**
     * При успешном подтверждении, создает нового {@link User}
     */
    @Override
    @Transactional
    public void confirmEmail(final String email, final String confirmCode) {

        final UserRegistrationRequest userRegistrationRequest = userRegistrationDao.findByEmail(email);

        if (userRegistrationRequest == null) {
            throw new UserRequestTimeOutException("User request not found, (time out)");
        }

        if (!userRegistrationRequest.getConfirmCode().equals(confirmCode)) {
            throw new ConfirmCodeException("Wrong confirm code");
        }

        final User user = new User();
        user.setUsername(userRegistrationRequest.getUsername());
        user.setEmail(userRegistrationRequest.getEmail());
        user.setPassword(userRegistrationRequest.getPassword());
        final Set<Authority> authorities = new HashSet<>();
        authorities.add(Authority.USER);
        user.setAuthorities(authorities);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setCreationTime(LocalDateTime.now());

        userDao.save(user);
        userRegistrationDao.delete(userRegistrationRequest);
    }

}
