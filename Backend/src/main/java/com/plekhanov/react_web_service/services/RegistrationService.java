package com.plekhanov.react_web_service.services;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 *
 */
@Validated
public interface RegistrationService {

    void registration(@NotNull String username, @NotNull String email, @NotNull String password);

}
