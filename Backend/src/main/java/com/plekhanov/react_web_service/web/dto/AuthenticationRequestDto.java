package com.plekhanov.react_web_service.web.dto;

import lombok.Value;

/**
 * Dto для аутентификации
 */
@Value
public class AuthenticationRequestDto {

    private String email;
    private String password;

}
