package com.plekhanov.react_web_service.model.entities;

import org.springframework.security.core.GrantedAuthority;

/**
 * Роли пользователя приложения
 */
public enum Authority implements GrantedAuthority {

    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
