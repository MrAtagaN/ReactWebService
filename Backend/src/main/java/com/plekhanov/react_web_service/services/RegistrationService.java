package com.plekhanov.react_web_service.services;

import org.springframework.validation.annotation.Validated;
import com.plekhanov.react_web_service.entities.User;
import javax.validation.constraints.NotNull;

/**
 * Сервис для создания нового {@link User}
 */
@Validated
public interface RegistrationService {

    /**
     * Запрос на создание нового {@link User}
     */
    void registrationRequest(@NotNull String username, @NotNull String email, @NotNull String password);


    /**
     * Подтверждение email ранее созданого {@link User}
     * @param email в Base64
     * @param confirmCode в Base64
     */
    void confirmEmail(@NotNull String email, @NotNull String confirmCode);

}
