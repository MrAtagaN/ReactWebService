package com.plekhanov.react_web_service;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.dao.ProductTypeDao;
import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.uploaders.ProductTypeUploader;
import com.plekhanov.react_web_service.uploaders.ProductUploader;
import com.plekhanov.react_web_service.uploaders.UserUploader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Наполнение базы демонстрационными данными
 */
@SpringBootApplication
public class DemoDataUploader {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = new SpringApplicationBuilder(DemoDataUploader.class)
                .web(WebApplicationType.NONE)
                .lazyInitialization(true)
                .run(args);
        System.exit(SpringApplication.exit(run));
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return (args) -> {
            //для правильного удаления не менять порядок
            context.getBean(UserDao.class).deleteAll();
            context.getBean(ProductDao.class).deleteAll();
            context.getBean(ProductTypeDao.class).deleteAll();


            context.getBean(UserUploader.class).uploadData();
            //сначала загружается тип продуктов, затем продукты
            context.getBean(ProductTypeUploader.class).uploadData();
            context.getBean(ProductUploader.class).uploadData();

        };
    }


}
