package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.utils.SecurityUtils;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import com.plekhanov.react_web_service.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {


    private final UserDao userDao;

    /**
     * Информация о текущем пользователе
     */
    @GetMapping("info")
    public ApiResponse<UserDto> getTestUser() {
        User currentUser = SecurityUtils.getCurrentUser();
        UserDto userDto = UserDto.builder()
                .id(currentUser.getId())
                .username(currentUser.getUsername())
                .password(currentUser.getPassword())
                .build();
        return ApiResponse.ok(userDto);
    }


}
