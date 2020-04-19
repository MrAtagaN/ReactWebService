package com.plekhanov.react_web_service.entities;

import com.plekhanov.react_web_service.web.security.Role;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Пользователь сервиса
 */
@Data
@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username; //аутентификация происходит по полю email

    @Column(name = "password")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<Role> authorities;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "last_enter", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastEnter;

    @Column(name = "email")
    private String email;

    //TODO добавить поля: дата регистрации, избранные товары, выбранные товары
}
