package com.plekhanov.react_web_service.web.api.dto;

import com.plekhanov.react_web_service.model.entities.User;
import lombok.Value;

/**
 * Dto для запроса на создание нового {@link User}
 */
@Value
public class RegistrationRequestDto {

    String email;
    String password;
    String username;

}
