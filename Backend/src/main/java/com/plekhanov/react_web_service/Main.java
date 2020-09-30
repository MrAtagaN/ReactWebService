package com.plekhanov.react_web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Запуск приложения
 * Приложение доступно на https://localhost:443/
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
    // ================
    // Не функциональные:
    // Добавить кэш для запросов
    // сделать csrf
    // Тест dao
    // Тесты controllers
    // Swagger
    // Валидация Entity
    // Зарефакторить POM
    // Ограничение длины полей объектов
    // Логгирование в коде
    // Добавить в базу больше товара
    // Заполнение данных в базе вынести в скрипты или сделать модуль common
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
