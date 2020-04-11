package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.web.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {

//    @Autowired
//    private UserDao userDao;

    /**
     * http://localhost/api/v1/user/test-user
     */
    @GetMapping("test-user")
    public ApiResponse<String> getTestUser() {

        return ApiResponse.ok("Secure information !");
    }


}
