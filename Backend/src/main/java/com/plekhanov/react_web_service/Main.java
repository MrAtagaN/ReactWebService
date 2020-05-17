package com.plekhanov.react_web_service;

import com.plekhanov.react_web_service.demo_data_uploader.DemoDataUploader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Запуск приложения
 * http://localhost:80/
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    /**
     * Выполнение при старте приложения
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return (args) -> {
            context.getBean(DemoDataUploader.class).insertData();
        };
    }


    //наполнить данными

    //TODO:
    // Функциональные:
    // Выводить данные постранично
    // Обработать ошибку, если нет эндпойнта
    // Модель данных
    // Добавить регистрацию пользователя
    // Https
    // .
    // Не функциональные:
    // Добавить кэш для запросов
    // сделать Transactional
    // сделать csrf
    // Тест базы
    // Тесты controllers
    // Ошибки записывать в отдельный файл
    // Swagger
    // Настроить бин валидацию
    // Зарефакторить POM
    //


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
