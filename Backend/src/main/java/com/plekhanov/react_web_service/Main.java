package com.plekhanov.react_web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * http://localhost:80/
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class} )
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    //TODO:
    // Тест базы
    // Тесты controllers
    // FlyWay
    // Ошибки записывать в отдельный файл
    // Swagger


    /**
     * Требования к Pull Request:
     *
     */

}
