package com.plekhanov.react_web_service.entities;

import com.plekhanov.react_web_service.config.security.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.FetchMode.SUBSELECT;

/**
 * Пользователь сервиса
 *
 * email должно быть уникальным
 * username, password - обязательные
 */
@Data
@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Column(name = "username", nullable = false)
    String username; //аутентификация происходит по полю email

    @ToString.Exclude
    @Column(name = "password", nullable = false)
    String password;

    @ElementCollection(fetch = EAGER)
    @Enumerated(STRING)
    @CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    Set<Role> authorities;

    @Column(name = "account_non_expired")
    boolean accountNonExpired;

    @Column(name = "account_non_locked")
    boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    boolean credentialsNonExpired;

    @Column(name = "enabled")
    boolean enabled;

    @Column(name = "enter", columnDefinition = "TIMESTAMP")
    LocalDateTime enter;

    @Column(name = "last_enter", columnDefinition = "TIMESTAMP")
    LocalDateTime lastEnter;

    @Column(name = "creation_time", columnDefinition = "TIMESTAMP")
    LocalDateTime creationTime;

    @Column(name = "email")
    String email;


    @ToString.Exclude          // чтобы не было кругового вызова toString, Equals, HashCode ломбоком
    @EqualsAndHashCode.Exclude // т.к. User и UserBagProduct имеют двунаправленную связь

    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "user_bag_product", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "product_id")
    @Column(name = "count")
    Map<Product, Integer> bagProducts = new HashMap<>();


    @ToString.Exclude          // чтобы не было кругового вызова toString, Equals, HashCode ломбоком,
    @EqualsAndHashCode.Exclude // т.к. User и UserFavoriteProduct имеют двунаправленную связь

    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "user_favorite_product", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "product_id")
    Set<Product> favoriteProducts = new HashSet<>();

    //TODO добавить поля: orders

}
