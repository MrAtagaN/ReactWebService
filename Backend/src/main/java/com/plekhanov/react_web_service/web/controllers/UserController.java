package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.services.UserService;
import com.plekhanov.react_web_service.utils.SecurityUtils;
import com.plekhanov.react_web_service.web.ApiResponse;
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

    private final UserService userService;

    private static final String PUBLIC = "public/";
    private static final String API_VERSION = "api/v1/user/";


    /**
     * Информация о текущем пользователе
     */
    @GetMapping(API_VERSION + "info")
    public ApiResponse<UserDto> getTestUser() {
        final User currentUser = SecurityUtils.getCurrentUser();
        final User foundUser = userService.findById(currentUser.getId());
        return ApiResponse.ok(UserDto.fromUser(foundUser));
    }


    /**
     * Добавить товар в корзину {@link User}
     */
    @PostMapping(API_VERSION + "add-product-to-bag")
    public ApiResponse<String> addProductToBag(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        userService.addProductToBag(productId, user);
        return ApiResponse.ok("product add to bag");
    }


    /**
     * Удалить товар из корзины {@link User}
     */
    @PostMapping(API_VERSION + "delete-product-from-bag")
    public ApiResponse<String> deleteProductFromBag(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        userService.deleteProductFromBag(productId, user);
        return ApiResponse.ok("product delete from bag");
    }


    /**
     * Добавить товар в избранное {@link User}
     */
    @PostMapping(API_VERSION + "add-product-to-favorite")
    public ApiResponse<String> addProductToFavorite(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        userService.addProductToFavorite(productId, user);
        return ApiResponse.ok("product add to favorite");
    }


    /**
     * Удалить товар из избранного {@link User}
     */
    @PostMapping(API_VERSION + "delete-product-from-favorite")
    public ApiResponse<String> deleteProductFromFavorite(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        userService.deleteProductFromFavorite(productId, user);
        return ApiResponse.ok("product delete from favorite");
    }


    /**
     * Регистрация нового {@link User}
     */
    @PostMapping(PUBLIC + API_VERSION + "registration")
    public ApiResponse<String> registration() {
        //TODO
        return null;
    }


}
