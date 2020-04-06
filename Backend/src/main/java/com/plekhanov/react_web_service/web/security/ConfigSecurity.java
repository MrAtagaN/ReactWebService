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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.plekhanov.react_web_service.web.dto.ApiResponse.ResponseCode.*;


/**
 * Конфигурация Security
 *
 * https://stackoverflow.com/questions/32498868/custom-login-form-configure-spring-security-to-get-a-json-response
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    final UserDetailsService userDetailsService;
    final ObjectMapper objectMapper;

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
                .deleteCookies("JSESSIONID");
        //.logoutSuccessHandler(logoutSuccessHandler());
    }

    /**
     * Конфигурация AuthenticationManager
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

            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setCode(OK.getValue());

            putApiResponseBodyInResponse(apiResponse, httpServletResponse);
        };
    }

    /**
     * Обработчик ошибки логина
     */
    private AuthenticationFailureHandler failureHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(401);

            ApiResponse apiResponse = ApiResponse.error(AUTHENTICATION_FAILURE, "Authentication failure");
            putApiResponseBodyInResponse(apiResponse, httpServletResponse);
        };
    }

    /**
     * Обработчик запрета доступа для пользователя
     */
    private AccessDeniedHandler accessDeniedHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(403);

            ApiResponse apiResponse = ApiResponse.error(ACCESS_DENIED, "Access denied");
            putApiResponseBodyInResponse(apiResponse, httpServletResponse);
        };
    }

    /**
     * Обработчик необходимости залогинится
     */
    private AuthenticationEntryPoint authenticationEntryPoint() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(401);

            ApiResponse apiResponse = ApiResponse.error(NOT_AUTHENTICATED, "Not authenticated");
            putApiResponseBodyInResponse(apiResponse, httpServletResponse);
        };
    }

    /**
     *
     */
    private void putApiResponseBodyInResponse(ApiResponse apiResponse, HttpServletResponse httpServletResponse) throws IOException {
        PrintWriter out = httpServletResponse.getWriter();
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        out.print(objectMapper.writeValueAsString(apiResponse));
        out.flush();
    }

//    private Filter csrfHeaderFilter() {
//        return new OncePerRequestFilter() {
//            @Override
//            protected void doFilterInternal(HttpServletRequest request,
//                                            HttpServletResponse response, FilterChain filterChain)
//                    throws ServletException, IOException {
//                CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
//                        .getName());
//                if (csrf != null) {
//                    Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
//                    String token = csrf.getToken();
//                    if (cookie == null || token != null
//                            && !token.equals(cookie.getValue())) {
//                        cookie = new Cookie("XSRF-TOKEN", token);
//                        cookie.setPath("/");
//                        response.addCookie(cookie);
//                    }
//                }
//                filterChain.doFilter(request, response);
//            }
//        };
//    }
//
//    private CsrfTokenRepository csrfTokenRepository() {
//        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//        repository.setHeaderName("X-XSRF-TOKEN");
//        return repository;
//    }

}
