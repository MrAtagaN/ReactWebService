package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Dao для {@link User}
 */
@Validated
public interface UserDao {

    List<User> findByName(@NotBlank String username);

    User findByEmail(@NotBlank String email);

    User findById(int id);
}
