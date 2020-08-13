package com.plekhanov.react_web_service;

import com.plekhanov.react_web_service.demoDataUploader.DemoDataUploader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class)
                .web(WebApplicationType.NONE)
                .lazyInitialization(true)
                .run(args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return (args) -> {
            context.getBean(DemoDataUploader.class).uploadData();
        };
    }


}
