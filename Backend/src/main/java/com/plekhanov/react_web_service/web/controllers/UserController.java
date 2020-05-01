package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.utils.SecurityUtils;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import com.plekhanov.react_web_service.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 *
 */
@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@Validated
public class UserController {

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
    @PostMapping("add-to-bag")
    public void addToBag() {
        //TODO
    }

    /**
     * Добавить товар в избранное
     */
    @PostMapping("add-to-favorite")
    public void addToFavorite() {
        //TODO
    }


}
