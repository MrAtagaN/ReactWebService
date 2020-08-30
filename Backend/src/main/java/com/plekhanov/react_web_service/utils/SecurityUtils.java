package com.plekhanov.react_web_service.utils;

import com.plekhanov.react_web_service.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    private SecurityUtils() {}

    /**
     * Получить текущего авторизованного пользователя
     */
    public static User getCurrentUser() {
        final SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext != null) {
            final Authentication authentication = securityContext.getAuthentication();
            if (authentication != null) {
                return (User) authentication.getPrincipal();
            }
        }
        return null;
    }

}
