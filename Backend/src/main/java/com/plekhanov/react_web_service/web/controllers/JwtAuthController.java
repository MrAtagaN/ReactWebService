package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.config.security.JwtService;
import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.web.ApiResponse;
import com.plekhanov.react_web_service.web.dto.AuthenticationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1")
public class JwtAuthController {

    @Autowired
    UserDao userDao;

    @Autowired
    JwtService jwtService;

    @Value("${jwt.cookie}")
    private String jwtCookieName;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    /**
     * login endpoint
     *
     * @param request email and password
     * @return JWT token
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO request) {
        User user = userDao.findByEmail(request.getEmail());
        if (bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword())) {
            String jwtToken = jwtService.createJwtToken(user.getEmail());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("SET-COOKIE", jwtCookieName + "=" + jwtToken + "; HttpOnly; Path=/");
            return ResponseEntity.ok().headers(httpHeaders).body(ApiResponse.ok("some data"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResponse.error(ApiResponse.ResponseCode.ACCESS_DENIED,
                            "Invalid email/password combination"));
        }
    }

}
