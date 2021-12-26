package com.plekhanov.react_web_service.services;

import org.springframework.validation.annotation.Validated;
import com.plekhanov.react_web_service.model.entities.User;
import javax.validation.constraints.NotNull;

/**
 * Сервис для создания нового {@link User}
 */
@Validated
public interface UserRegistrationService {

    /**
     * Запрос на создание нового {@link User}, нужно подтвердить
     */
    void userRegistrationRequest(@NotNull String username, @NotNull String email, @NotNull String password);


    /**
     * Подтверждение email пользователя c помощью кода высланного на email
     * @param email пользователя в Base64
     * @param confirmCode в Base64
     */
    void confirmEmail(@NotNull String email, @NotNull String confirmCode);

}
