package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Dao для {@link User}
 */
@Validated
public interface UserDao {

    /**
     * Ищет {@link User} по полю username
     */
    User findByName(@NotBlank String username);

    User findById(@NotNull Integer id);
}
