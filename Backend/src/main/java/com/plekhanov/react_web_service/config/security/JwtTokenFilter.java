package com.plekhanov.react_web_service.config.security;

import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends GenericFilterBean {

    @Autowired
    JwtService jwtService;

    @Autowired
    UserService userService;

    @Value("${jwt.cookie}")
    private String jwtCookieName;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(jwtCookieName)) {
                    token = cookie.getValue();
                }
            }
        }

        try {
            if (token != null && jwtService.validateToken(token)) {
                Authentication authentication = getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            SecurityContextHolder.clearContext();
            ((HttpServletResponse) servletResponse).sendError(HttpStatus.UNAUTHORIZED.value());
            throw new RuntimeException("JWT token is expired or invalid");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }


    private Authentication getAuthentication(String token) {
        final String email = jwtService.getEmailFromToken(token);
        User user = userService.findByEmail(email);
        return new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
    }



}
