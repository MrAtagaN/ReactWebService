package com.plekhanov.react_web_service;

import com.plekhanov.react_web_service.demo_data_uploader.DemoDataUploader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Запуск приложения
 * Приложение доступно на http://localhost:80/
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
            //загрузка в базу тестовых данных
            context.getBean(DemoDataUploader.class).uploadData();
        };
    }


    //текущее: Загрузка тестовых фото

    //TODO:
    // Функциональные:
    // На фронте Выводить данные постранично
    // Обработать ошибку, если нет эндпойнта
    // Добавить регистрацию пользователя
    // Https
    // ================
    // Не функциональные:
    // Загрузка тестовых фото
    // В продуктах размер сделать сет. В типах продуктов сделать привязку к полу
    // Добавить кэш для запросов
    // сделать Transactional
    // сделать csrf
    // Тест dao
    // Тесты controllers
    // Ошибки записывать в отдельный файл
    // Swagger
    // Валидация Entity
    // Зарефакторить POM
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
