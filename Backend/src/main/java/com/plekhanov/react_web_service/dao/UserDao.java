package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Dao для {@link User}
 */
@Validated
public interface UserDao extends JpaRepository<User, Integer> {

    User findById(int id);

    List<User> findByUsername(@NotBlank String username);

    User findByEmail(@NotBlank String email);

}
