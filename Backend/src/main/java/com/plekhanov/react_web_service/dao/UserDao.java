package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Dao для {@link User}
 */
@Validated
public interface UserDao {

    /**
     * Ищет {@link User} по полю username
     */
    List<User> findByName(@NotBlank String username);

    /**
     * Ищет {@link User} по полю email
     */
    User findByEmail(@NotBlank String email);

    User findById(@NotNull Integer id);
}
