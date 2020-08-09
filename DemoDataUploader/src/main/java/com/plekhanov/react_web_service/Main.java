package com.plekhanov.react_web_service;

import com.plekhanov.react_web_service.demoDataUploader.DemoDataUploader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        applicationContext.getBean(DemoDataUploader.class).uploadData();
    }
}
