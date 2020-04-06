package com.plekhanov.react_web_service.web.security;

import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Сервис возвращающий Информацию о правах доступа пользователя по имени.
 * Нужен для {@link AuthenticationManager} фремворка spring.security
 */
@RequiredArgsConstructor
@Service
public class AppUserDetailService implements UserDetailsService {

    private final UserDao userDao;

    /**
     * Возвращает Информацию о правах доступа пользователя по имени
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userDao.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found!");
        }
        return user;
    }


}
