package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.utils.SecurityUtils;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
@Validated
@Secured("ADMIN")
public class AdminController {

    /**
     * Убрать !!!
     */
    @GetMapping("info")

    public ApiResponse<String> getTestUser() {

        return ApiResponse.ok("ADMIN INFO");
    }
}
