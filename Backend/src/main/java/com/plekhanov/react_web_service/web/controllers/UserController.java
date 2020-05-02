package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.services.ProductService;
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

    private final ProductService productService;

    /**
     * Информация о текущем пользователе
     */
    @GetMapping("info")
    public ApiResponse<UserDto> getTestUser() {
        final User currentUser = SecurityUtils.getCurrentUser();
        return ApiResponse.ok(UserDto.fromUser(currentUser));
    }

    /**
     * Добавить товар в корзину
     */
    @PostMapping("add-product-to-bag")
    public ApiResponse<String> addProductToBag(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        productService.addProductToBag(productId, user);
        return ApiResponse.ok("product add to bag");
    }

    /**
     * Удалить товар из корзины
     */
    @PostMapping("delete-product-from-bag")
    public ApiResponse<String> deleteProductFromBag(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        productService.deleteProductFromBag(productId, user);
        return ApiResponse.ok("product delete from bag");
    }

    /**
     * Добавить товар в избранное
     */
    @PostMapping("add-product-to-favorite")
    public ApiResponse<String> addProductToFavorite(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        productService.addProductToFavorite(productId, user);
        return ApiResponse.ok("product add to favorite");
    }

    /**
     * Удалить товар из избранного
     */
    @PostMapping("delete-product-from-favorite")
    public ApiResponse<String> deleteProductFromFavorite(
            @RequestParam("productId") @NotNull final Integer productId) {

        final User user = SecurityUtils.getCurrentUser();
        //TODO
        return ApiResponse.ok("product delete from favorite");
    }


}
