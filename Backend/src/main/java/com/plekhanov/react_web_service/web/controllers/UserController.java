package com.plekhanov.react_web_service.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
public class UserController {

//    @Autowired
//    private UserDao userDao;

    /**
     * http://localhost/v1/user/test-user
     */
    @GetMapping("test-user")
    public String getTestUser() {

        return "Secure user";
    }


}
