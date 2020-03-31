package com.plekhanov.react_web_service.web.security;

import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Сервис возвращающий Права и доступы пользователя по имени
 */
@RequiredArgsConstructor
@Service("AppUserDetailService")
public class AppUserDetailService implements UserDetailsService {

    final UserDao userDao;

    /**
     *
     */
    @Override
    public UserDetails loadUserByUsername(String userName) {
        User user = userDao.findByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User " + userName + " not found!");
        }
        return user;
    }


}
