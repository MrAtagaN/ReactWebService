package com.plekhanov.react_web_service.web.api.dto;


import lombok.Value;

/**
 * Dto для подтверждения регистрации пользователя
 */
@Value
public class ConfirmDto {

    String email;
    String confirmCode;

}
