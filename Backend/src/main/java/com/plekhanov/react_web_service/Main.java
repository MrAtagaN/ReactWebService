package com.plekhanov.react_web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * http://localhost:80/
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    //TODO:
    // сделать csrf
    // Тест базы
    // Тесты controllers
    // Ошибки записывать в отдельный файл
    // Swagger
    // Настроить бин валидацию


    /**
     * Требования к Pull Request:
     *
     * валидировать параметры NotNull, Size, NotBlank, NotEmpty
     * модификаторы final у параметров методов
     * Immutable классы
     * Внедрение зависимостец через конструкотор
     * Java doc. Что делает, для чего нужно
     * Понятные названия методов и переменных
     * Переменные вынесены в property
     * Чистые функции
     * Индексы на внешние ключи
     * Логирование
     * Тесты
     * Применение паттернов
     */

}
