package com.plekhanov.react_web_service.model.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Запрос на создание нового {@link User}
 *
 * email должно быть уникальным
 * username, password, creationTime, confirmCode - обязательные
 */
@Data
@Entity(name = "UserRegistrationRequest")
@Table(name = "user_registration_request")
public class UserRegistrationRequest {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Column(name = "username", nullable = false)
    String username;

    @ToString.Exclude
    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "creation_time", columnDefinition = "TIMESTAMP", nullable = false)
    LocalDateTime creationTime;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "confirm_code", nullable = false)
    String confirmCode;



}
