package com.plekhanov.react_web_service.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("api/v1/login")
public class LoginController {

    /**
     * http://localhost/api/v1/login/singin
     *
     *
     */
    @GetMapping("singin")
    public String getTestUser() {

        return "Singin";
    }
}
