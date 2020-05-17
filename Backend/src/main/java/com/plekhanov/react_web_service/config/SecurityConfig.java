package com.plekhanov.react_web_service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plekhanov.react_web_service.config.security.EmailAuthenticationProvider;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.utils.SecurityUtils;
import com.plekhanov.react_web_service.web.ApiResponse;
import com.plekhanov.react_web_service.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.plekhanov.react_web_service.web.ApiResponse.ResponseCode.*;

/**
 * Конфигурация Security
 * https://stackoverflow.com/questions/32498868/custom-login-form-configure-spring-security-to-get-a-json-response
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ObjectMapper objectMapper;
    private final EmailAuthenticationProvider emailAuthenticationProvider;

    /**
     * Настройка открытых эндпойнтов
     */
    public void configure(final WebSecurity webSecurity) {
        webSecurity.ignoring()
                .antMatchers("/")
                .antMatchers("/*")
                .antMatchers("/static/**")
                .antMatchers("/images/**")
                .antMatchers("/public/**");
    }

    /**
     * Настройка защищенных эндпойнтов
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").access("hasAuthority('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .cors()
                .configurationSource(corsConfiguration())
                .and()
                .formLogin()
                .successHandler(successHandler())
                .failureHandler(failureHandler())
                .loginProcessingUrl("/api/v1/login")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .logout()
                .logoutUrl("/api/v1/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler());
    }

    /**
     * Конфигурация AuthenticationManager
     * Нужен для авторизации и аутентификации пользователя классом {@link AuthenticationManager} фреймворка spring.security
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(emailAuthenticationProvider);
    }


    /**
     * Обработчик успешного логина
     */
    private AuthenticationSuccessHandler successHandler() {
        return (httpServletRequest, httpServletResponse, authentication) -> {
            httpServletResponse.setStatus(200);
            final User currentUser = SecurityUtils.getCurrentUser();
            putApiResponseInServletResponse(ApiResponse.ok(UserDto.fromUser(currentUser)), httpServletResponse);
        };
    }


    /**
     * Обработчик ошибки логина
     */
    private AuthenticationFailureHandler failureHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(401);
            final ApiResponse apiResponse = ApiResponse.error(AUTHENTICATION_FAILURE, "Authentication failure");
            putApiResponseInServletResponse(apiResponse, httpServletResponse);
        };
    }


    /**
     * Обработчик отказа доступа
     */
    private AccessDeniedHandler accessDeniedHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(403);
            final ApiResponse apiResponse = ApiResponse.error(ACCESS_DENIED, "Access denied");
            putApiResponseInServletResponse(apiResponse, httpServletResponse);
        };
    }


    /**
     * Обработчик неаутентифицированного запроса
     */
    private AuthenticationEntryPoint authenticationEntryPoint() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(401);
            final ApiResponse apiResponse = ApiResponse.error(NOT_AUTHENTICATED, "Not authenticated");
            putApiResponseInServletResponse(apiResponse, httpServletResponse);
        };
    }


    /**
     * Обработчик успешного разлогина
     */
    private LogoutSuccessHandler logoutSuccessHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(200);
            putApiResponseInServletResponse(ApiResponse.ok(null), httpServletResponse);
        };
    }


    /**
     * Кладет {@link ApiResponse} в {@link HttpServletResponse}
     */
    private void putApiResponseInServletResponse(final ApiResponse apiResponse,
                                                 final HttpServletResponse httpServletResponse) throws IOException {

        final PrintWriter out = httpServletResponse.getWriter();
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        out.print(objectMapper.writeValueAsString(apiResponse));
        out.flush();
    }


    /**
     * CORS конфигурация.
     * Нужна для возможности запускать фронт на другом сервере (для отладки)
     */
    private CorsConfigurationSource corsConfiguration() {
        return (httpServletRequest) -> {
            final CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.addAllowedOrigin("http://localhost:3000");
            corsConfiguration.addAllowedMethod(HttpMethod.POST);
            corsConfiguration.addAllowedMethod(HttpMethod.GET);
            corsConfiguration.setAllowCredentials(true);
            return corsConfiguration;
        };
    }


}