package com.plekhanov.react_web_service.web.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.plekhanov.react_web_service.web.dto.ApiResponse.ResponseCode.*;


/**
 * Конфигурация Security
 * <p>
 * https://stackoverflow.com/questions/32498868/custom-login-form-configure-spring-security-to-get-a-json-response
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final ObjectMapper objectMapper;

    /**
     * Настройка открытых эндпойнтов
     */
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring()
                .antMatchers("/")
                .antMatchers("/static/**")
                .antMatchers("*.js")
                .antMatchers("*.html")
                .antMatchers("*.css")
                .antMatchers("*.png")
                .antMatchers("*.ico");
    }

    /**
     * Настройка защищенных эндпойнтов
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
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
     * Нужен для авторизации и аутентификации пользователя фреймворком spring.security
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }


    /**
     * Обработчик успешного логина
     */
    private AuthenticationSuccessHandler successHandler() {
        return (httpServletRequest, httpServletResponse, authentication) -> {
            httpServletResponse.setStatus(200);
            putApiResponseInServletResponse(ApiResponse.ok(null), httpServletResponse);
        };
    }

    /**
     * Обработчик ошибки логина
     */
    private AuthenticationFailureHandler failureHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(401);

            ApiResponse apiResponse = ApiResponse.error(AUTHENTICATION_FAILURE, "Authentication failure");
            putApiResponseInServletResponse(apiResponse, httpServletResponse);
        };
    }

    /**
     * Обработчик запрета доступа для пользователя
     */
    private AccessDeniedHandler accessDeniedHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(403);

            ApiResponse apiResponse = ApiResponse.error(ACCESS_DENIED, "Access denied");
            putApiResponseInServletResponse(apiResponse, httpServletResponse);
        };
    }

    /**
     * Обработчик необходимости залогинится
     */
    private AuthenticationEntryPoint authenticationEntryPoint() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(401);

            ApiResponse apiResponse = ApiResponse.error(NOT_AUTHENTICATED, "Not authenticated");
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
    private void putApiResponseInServletResponse(ApiResponse apiResponse, HttpServletResponse httpServletResponse) throws IOException {
        PrintWriter out = httpServletResponse.getWriter();
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        out.print(objectMapper.writeValueAsString(apiResponse));
        out.flush();
    }


}
