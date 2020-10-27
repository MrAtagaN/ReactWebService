package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.config.security.EmailPasswordAuthService;
import com.plekhanov.react_web_service.config.security.JwtService;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.mapper.UserMapper;
import com.plekhanov.react_web_service.web.api.ApiResponse;
import com.plekhanov.react_web_service.web.api.dto.AuthenticationRequestDto;
import com.plekhanov.react_web_service.web.api.dto.UserDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import static java.text.MessageFormat.format;


/**
 * Эндпойнт для аутентификации
 */
@RestController
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

    private static final String PUBLIC = "public/";
    private static final String API_VERSION = "api/v1/login";

    UserMapper userMapper;
    JwtService jwtService;
    String cookieTemplate;
    EmailPasswordAuthService emailPasswordAuthService;

    public AuthController(final JwtService jwtService,
                          final @Value("${jwt.cookie.name}") String jwtCookieName,
                          final EmailPasswordAuthService emailPasswordAuthService,
                          final UserMapper userMapper) {
        this.userMapper = userMapper;
        this.jwtService = jwtService;
        this.emailPasswordAuthService = emailPasswordAuthService;
        this.cookieTemplate = jwtCookieName + "={0}; HttpOnly; Path=/";
    }


    /**
     * login endpoint
     *
     * @param request email and password
     * @return JWT token in cookie
     */
    @PostMapping(PUBLIC + API_VERSION)
    public ResponseEntity<ApiResponse<UserDto>> login(@RequestBody @NotNull final AuthenticationRequestDto request) {
        final String email = request.getEmail();
        final User user = emailPasswordAuthService.authenticate(email, request.getPassword());
        final String jwtToken = jwtService.createJwtToken(email);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("SET-COOKIE", format(cookieTemplate, jwtToken));
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(ApiResponse.ok(userMapper.userToUserDto(user)));
    }

}
