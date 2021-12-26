package com.plekhanov.react_web_service.services;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Создание и обработка JWT токена
 */
@Validated
public interface JwtService {

    String createJwtToken(@NotNull String email);

    String validateTokenAndGetEmail(@NotNull String token);
}
