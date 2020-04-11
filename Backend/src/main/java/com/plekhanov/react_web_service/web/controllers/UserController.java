package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
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
     * http://localhost/api/v1/user/test-user
     */
    @GetMapping("test-user")
    public ApiResponse<User> getTestUser() {

        User user = new User();
        user.setUsername("test name");
        return ApiResponse.ok(user);
    }


}
