package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.services.UserService;
import com.plekhanov.react_web_service.utils.SecurityUtils;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import com.plekhanov.react_web_service.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


/**
 * Защищеные эндпойты действий пользователя
 */
@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    /**
     * Информация о текущем пользователе
     */
    @GetMapping("info")
    public ApiResponse<UserDto> getTestUser() {
        final User currentUser = SecurityUtils.getCurrentUser();
        final User foundUser = userService.findById(currentUser.getId());
        return ApiResponse.ok(UserDto.fromUser(foundUser));
    }

    /**
     * Добавить товар в корзину
     */
    @PostMapping("add-product-to-bag")
    public ApiResponse<String> addProductToBag(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        userService.addProductToBag(productId, user);
        return ApiResponse.ok("product add to bag");
    }

    /**
     * Удалить товар из корзины
     */
    @PostMapping("delete-product-from-bag")
    public ApiResponse<String> deleteProductFromBag(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        userService.deleteProductFromBag(productId, user);
        return ApiResponse.ok("product delete from bag");
    }

    /**
     * Добавить товар в избранное
     */
    @PostMapping("add-product-to-favorite")
    public ApiResponse<String> addProductToFavorite(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        userService.addProductToFavorite(productId, user);
        return ApiResponse.ok("product add to favorite");
    }

    /**
     * Удалить товар из избранного
     */
    @PostMapping("delete-product-from-favorite")
    public ApiResponse<String> deleteProductFromFavorite(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        userService.deleteProductFromFavorite(productId, user);
        return ApiResponse.ok("product delete from favorite");
    }


}
