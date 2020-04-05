package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.web.dto.ApiResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping(value = "singin")
    public ResponseEntity<ApiResponseBody> getTestUser() {
        ApiResponseBody apiResponseBody = new ApiResponseBody();
        apiResponseBody.setCode(2);
        apiResponseBody.setErrorMessage("you need login");

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(apiResponseBody);
    }

}
