package com.plekhanov.react_web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Запуск приложения
 * Приложение доступно на http://localhost:80/
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }



    //текущее: На фронте отображать товар
    //юнит тесты

    //TODO:
    // Функциональные:
    // На фронте Выводить данные постранично
    // Обработать ошибку, если нет эндпойнта
    // Добавить регистрацию пользователя
    // Https
    // Настроить запись логов
    // ================
    // Не функциональные:
    // Добавить в базу больше товара
    // Добавить кэш для запросов
    // сделать csrf
    // Тест dao
    // Тесты controllers
    // Ошибки записывать в отдельный файл
    // Swagger
    // Валидация Entity
    // Зарефакторить POM
    // Ограничение длины названий
    // Логгирование в коде
    //


    /**
     * Требования к Pull Request:
     *
     * валидировать параметры NotNull, Size, NotBlank, NotEmpty
     * Чистые функции
     * модификаторы final у параметров методов
     * Immutable классы
     * Внедрение зависимостей через конструкотор
     * Java doc. Что делает, для чего нужно
     * Понятные названия методов и переменных
     * Переменные вынесены в property
     * Индексы на внешние ключи
     * Логирование
     * Тесты
     * Применение паттернов
     */

}
