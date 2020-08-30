package com.plekhanov.react_web_service.web.controllers;


import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.services.RegistrationService;
import com.plekhanov.react_web_service.web.api.ApiResponse;
import com.plekhanov.react_web_service.web.api.dto.RegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Эндпойты для создания нового {@link User}
 */
@RestController
@RequiredArgsConstructor
@Validated
public class RegistrationController {

    private final RegistrationService registrationService;

    private static final String PUBLIC = "public/";
    private static final String API_VERSION = "api/v1/registration/";


    /**
     * Запрос на создание нового {@link User}
     */
    @PostMapping(PUBLIC + API_VERSION + "request")
    public ApiResponse<String> registrationRequest(@RequestBody @NotNull final RegistrationRequestDto requestDto) {
        registrationService.registrationRequest(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());
        return ApiResponse.ok("user registration request accepted");
    }


    /**
     * Подтверждение email нового {@link User}
     * @param email в Base64
     * @param confirmCode в Base64
     */
    @PostMapping(PUBLIC + API_VERSION + "confirm-email/{email}/{hashCode}")
    public ApiResponse<String> confirmEmail(@PathVariable @NotNull final String email,
                                            @PathVariable @NotNull final String confirmCode) {
        registrationService.confirmEmail(email, confirmCode);
        return ApiResponse.ok("new user created");
    }
}
