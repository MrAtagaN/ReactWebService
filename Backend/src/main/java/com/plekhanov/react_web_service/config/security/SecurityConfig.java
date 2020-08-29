package com.plekhanov.react_web_service.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plekhanov.react_web_service.web.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.plekhanov.react_web_service.web.ApiResponse.ResponseCode.ACCESS_DENIED;
import static com.plekhanov.react_web_service.web.ApiResponse.ResponseCode.NOT_AUTHENTICATED;


/**
 * Конфигурация Security
 * https://stackoverflow.com/questions/32498868/custom-login-form-configure-spring-security-to-get-a-json-response
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String logoutUrl = "/api/v1/logout";
    private final String logoutSuccessUrl = "/";

    private final ObjectMapper objectMapper;
    private final JwtTokenFilter jwtTokenFilter;
    private final String jwtCookieName;


    public SecurityConfig(final ObjectMapper objectMapper,
                          final JwtTokenFilter jwtTokenFilter,
                          final @Value("${jwt.cookie.name}") String jwtCookieName) {
        this.objectMapper = objectMapper;
        this.jwtTokenFilter = jwtTokenFilter;
        this.jwtCookieName = jwtCookieName;
    }


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
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("/api/v1/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .logout()
                .logoutUrl(logoutUrl)
                .deleteCookies(jwtCookieName)
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl(logoutSuccessUrl)
                .logoutSuccessHandler(logoutSuccessHandler());
    }


    /**
     * Обработчик отказа доступа
     */
    private AccessDeniedHandler accessDeniedHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(403);
            final ApiResponse<String> apiResponse = ApiResponse.error(ACCESS_DENIED, "Access denied");
            putApiResponseInServletResponse(apiResponse, httpServletResponse);
        };
    }


    /**
     * Обработчик неаутентифицированного запроса
     */
    private AuthenticationEntryPoint authenticationEntryPoint() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(401);
            final ApiResponse<String> apiResponse = ApiResponse.error(NOT_AUTHENTICATED, "Not authenticated");
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
    private void putApiResponseInServletResponse(final ApiResponse<?> apiResponse,
                                                 final HttpServletResponse httpServletResponse) throws IOException {

        final PrintWriter out = httpServletResponse.getWriter();
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        out.print(objectMapper.writeValueAsString(apiResponse));
        out.flush();
    }

}
