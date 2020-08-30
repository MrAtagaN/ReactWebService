package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.services.RegistrationService;
import com.plekhanov.react_web_service.services.UserService;
import com.plekhanov.react_web_service.web.ApiResponse;
import com.plekhanov.react_web_service.web.dto.RegistrationRequestDto;
import com.plekhanov.react_web_service.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * Эндпойты для действий {@link User}
 */
@RestController
@RequiredArgsConstructor
@Validated
public class UserController {

    private final RegistrationService registrationService;
    private final UserService userService;

    private static final String PUBLIC = "public/";
    private static final String API_VERSION = "api/v1/user/";


    /**
     * Информация о текущем пользователе
     */
    @GetMapping(API_VERSION + "info")
    public ApiResponse<UserDto> getInfo() {
        final User currentUser = userService.getCurrentUser();
        return ApiResponse.ok(UserDto.fromUser(currentUser));
    }


    /**
     * Добавить товар в корзину {@link User}
     */
    @PostMapping(API_VERSION + "add-product-to-bag")
    public ApiResponse<String> addProductToBag(@RequestParam("productId") @NotNull final Integer productId) {
        final User user = userService.getCurrentUser();
        userService.addProductToBag(productId, user);
        return ApiResponse.ok("product add to bag");
    }


    /**
     * Удалить товар из корзины {@link User}
     */
    @PostMapping(API_VERSION + "delete-product-from-bag")
    public ApiResponse<String> deleteProductFromBag(@RequestParam("productId") @NotNull final Integer productId) {
        final User user = userService.getCurrentUser();
        userService.deleteProductFromBag(productId, user);
        return ApiResponse.ok("product delete from bag");
    }


    /**
     * Добавить товар в избранное {@link User}
     */
    @PostMapping(API_VERSION + "add-product-to-favorite")
    public ApiResponse<String> addProductToFavorite(@RequestParam("productId") @NotNull final Integer productId) {
        final User user = userService.getCurrentUser();
        userService.addProductToFavorite(productId, user);
        return ApiResponse.ok("product add to favorite");
    }


    /**
     * Удалить товар из избранного {@link User}
     */
    @PostMapping(API_VERSION + "delete-product-from-favorite")
    public ApiResponse<String> deleteProductFromFavorite(@RequestParam("productId") @NotNull final Integer productId) {
        final User user = userService.getCurrentUser();
        userService.deleteProductFromFavorite(productId, user);
        return ApiResponse.ok("product delete from favorite");
    }


    /**
     * Регистрация нового {@link User}
     */
    @PostMapping(PUBLIC + API_VERSION + "registration")
    public ApiResponse<String> registration(@RequestBody @NotNull final RegistrationRequestDto requestDto) {
        registrationService.registration(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());
        return ApiResponse.ok("user registration request accepted");
    }


}
