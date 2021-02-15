package com.plekhanov.react_web_service.config.security;

import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Фильтр запросов. Валидирурет JWT токен, который приходит в cookie.
 */
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtTokenFilter extends GenericFilterBean {

    JwtService jwtService;
    UserService userService;
    String jwtCookieName;

    public JwtTokenFilter(final JwtService jwtService,
                          final UserService userService,
                          final @Value("${jwt.cookie.name}") String jwtCookieName) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.jwtCookieName = jwtCookieName;
    }


    @Override
    public void doFilter(final ServletRequest servletRequest,
                         final ServletResponse servletResponse,
                         final FilterChain filterChain) throws IOException, ServletException {
        authenticateProcessJwt(servletRequest);
        filterChain.doFilter(servletRequest, servletResponse);
    }


    /**
     * Валидирует JWT токен, кладет {@link Authentication} в {@link SecurityContext}
     */
    private void authenticateProcessJwt(final ServletRequest servletRequest) {
        final String token = getTokenFromCookie(servletRequest);

        if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
           try{
               final String email = jwtService.validateTokenAndGetEmail(token);
               final User user = userService.findByEmail(email);
               final Authentication authentication = new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
               SecurityContextHolder.getContext().setAuthentication(authentication);
           } catch (Exception e) {
               SecurityContextHolder.clearContext();
           }
        }
    }


    /**
     * Достает JWT токен из cookie запроса
     */
    private String getTokenFromCookie(final ServletRequest servletRequest) {
        final Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(jwtCookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }


}
