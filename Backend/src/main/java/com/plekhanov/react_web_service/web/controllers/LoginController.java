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
//    @GetMapping("singin")
//    public ResponseEntity<ApiResponse> getTestUser() {
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setCode(2);
//        apiResponse.setErrorMessage("you need login");
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .header("Content-Type", "text/plain; charset=UTF-8")
//                .body(apiResponse);
//    }

    @GetMapping("singin")
    public String getTestUser() {
        return "Login page";
    }
}
