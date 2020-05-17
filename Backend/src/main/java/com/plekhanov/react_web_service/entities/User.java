package com.plekhanov.react_web_service.entities;

import com.plekhanov.react_web_service.web.security.Role;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.FetchMode.SUBSELECT;

/**
 * Пользователь сервиса
 */
@Data
@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username; //аутентификация происходит по полю email

    @ToString.Exclude
    @Column(name = "password")
    private String password;

    @ElementCollection(fetch = EAGER)
    @Enumerated(STRING)
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

    @Column(name = "enter", columnDefinition = "TIMESTAMP")
    private LocalDateTime enter; //

    @Column(name = "last_enter", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastEnter;

    @Column(name = "creation_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime creationTime;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user", cascade = ALL, orphanRemoval = true, fetch = EAGER)
    private List<UserBagProduct> bagProducts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = ALL, orphanRemoval = true, fetch = EAGER)
    @Fetch(SUBSELECT) // по умолчанию используется JOIN, но это не будет работать если есть две коллекции с fetch = EAGER
    private Set<UserFavoriteProduct> favoriteProducts = new HashSet<>();

    //TODO добавить поля: orders

}
