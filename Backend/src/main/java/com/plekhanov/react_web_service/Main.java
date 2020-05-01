package com.plekhanov.react_web_service;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Collections;

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
     * Отладка
     **/
//    @Autowired
//    ProductDao productDao;
//
//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext context) {
//        return (args) -> {
//            Product product = new Product();
//            product.setType("typeAAAA");
//            product.setPrice(new BigDecimal("100.1"));
//            product.setName("aaadvcv");
//            product.setProductCategory(Product.ProductCategory.ACCESSORIES);
//            product.setGenderCategory(Product.GenderCategory.MALE);
//
//            product.setImages(Collections.singleton(new byte[]{0,2,3}));
//            productDao.save(product);
//
//            Product byId = productDao.findById(1);
//            System.out.println(byId);
//        };
//    }


    //TODO:
    // Функциональные:
    // Модель данных
    // Поиск продуктов
    // Фильтрация продуктов
    // Добавить регистрацию пользователя
    // Https
    // Не функциональные:
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
