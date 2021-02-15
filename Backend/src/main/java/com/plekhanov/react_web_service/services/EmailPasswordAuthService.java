package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * Аутентификация по email и паролю.
 */
@Validated
public interface EmailPasswordAuthService {

    /**
     * Сверяет введенные пользователем email и пароль с
     * email и паролем {@link User} в базе
     */
    User authenticate(@NotBlank String email, @NotBlank String password);
}
