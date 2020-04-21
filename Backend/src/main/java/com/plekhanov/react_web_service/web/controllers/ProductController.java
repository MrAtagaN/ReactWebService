package com.plekhanov.react_web_service.web.controllers;


import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.utils.SecurityUtils;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import com.plekhanov.react_web_service.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
@Validated
public class ProductController {

    /**
     * Информация о текущем пользователе
     */
    @GetMapping("list")
    public ApiResponse<String> searchProducts() {

        return ApiResponse.ok("Products");
    }

}
