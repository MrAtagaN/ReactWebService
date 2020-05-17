package com.plekhanov.react_web_service.config.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Роли пользователя приложения
 */
public enum Role implements GrantedAuthority {

    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
