package com.plekhanov.react_web_service.web.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.Filter;
import java.util.jar.JarOutputStream;

/**
 * Конфигурация Security
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    final UserDetailsService userDetailsService;

    /**
     * Настройка открытых эндпойнтов
     *
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
                .loginPage("/login.html")//TODO поменять
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/api/v1/user/test-user", true) //TODO поменять на /
                //.failureUrl("/login.html?error=true") //редирект на эндпойнт при ошибке логина
                //.failureHandler(authenticationFailureHandler())  //TODO cделать
                .and()
                .logout()
                .logoutUrl("/logout")
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

}
