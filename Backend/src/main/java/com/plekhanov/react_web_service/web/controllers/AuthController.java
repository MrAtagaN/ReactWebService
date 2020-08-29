package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.config.security.EmailPasswordAuthService;
import com.plekhanov.react_web_service.config.security.JwtService;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.web.ApiResponse;
import com.plekhanov.react_web_service.web.dto.AuthenticationRequestDto;
import com.plekhanov.react_web_service.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Эндпойнт для аутентификации
 */
@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final JwtService jwtService;
    private final String jwtCookieName;
    private final EmailPasswordAuthService emailPasswordAuthService;

    public AuthController(final JwtService jwtService,
                          final @Value("${jwt.cookie.name}") String jwtCookieName,
                          final EmailPasswordAuthService emailPasswordAuthService) {
        this.jwtService = jwtService;
        this.jwtCookieName = jwtCookieName;
        this.emailPasswordAuthService = emailPasswordAuthService;
    }


    /**
     * login endpoint
     *
     * @param request email and password
     * @return JWT token in cookie
     */
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserDto>> login(final @RequestBody AuthenticationRequestDto request) {
        final String email = request.getEmail();
        final User user = emailPasswordAuthService.authenticate(email, request.getPassword());
        final String jwtToken = jwtService.createJwtToken(email);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("SET-COOKIE", jwtCookieName + "=" + jwtToken + "; HttpOnly; Path=/");
        return ResponseEntity.ok().headers(httpHeaders).body(ApiResponse.ok(UserDto.fromUser(user)));
    }

}
