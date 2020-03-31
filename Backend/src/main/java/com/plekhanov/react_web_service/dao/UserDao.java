package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public interface UserDao {

    User findByName(@NotBlank String userName);
}
