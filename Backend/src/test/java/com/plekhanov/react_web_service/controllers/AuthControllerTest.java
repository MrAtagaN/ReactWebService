package com.plekhanov.react_web_service.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plekhanov.react_web_service.config.security.EmailPasswordAuthService;
import com.plekhanov.react_web_service.config.security.JwtService;
import com.plekhanov.react_web_service.config.security.JwtTokenFilter;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.web.api.ApiResponse;
import com.plekhanov.react_web_service.web.api.dto.AuthenticationRequestDto;
import com.plekhanov.react_web_service.web.api.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    EmailPasswordAuthService emailPasswordAuthService;

    @MockBean
    JwtService jwtService;

    @Test
    public void loginTest() throws Exception {

        final String email = "testEmail";
        final String password = "testPassword";
        final String token = "token-!@#$%^";

        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto(email, password);

        User user = new User();
        user.setUsername("Max");
        user.setEmail(email);

        Mockito.when(jwtService.createJwtToken(email)).thenReturn(token);
        Mockito.when(emailPasswordAuthService.authenticate(email, password)).thenReturn(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/login")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(authenticationRequestDto)))
                .andExpect(content().string(objectMapper.writeValueAsString(
                        ApiResponse.ok(UserDto.fromUser(user)))));
    }
}
