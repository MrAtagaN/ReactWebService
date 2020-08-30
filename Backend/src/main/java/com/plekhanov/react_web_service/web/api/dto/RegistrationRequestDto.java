package com.plekhanov.react_web_service.web.api.dto;


import com.plekhanov.react_web_service.entities.User;
import lombok.Builder;
import lombok.Value;

/**
 * Dto для запроса на создание нового {@link User}
 */
@Value
@Builder
public class RegistrationRequestDto {

    String username;
    String email;
    String password;

}
