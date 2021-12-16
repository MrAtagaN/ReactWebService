package com.plekhanov.react_web_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;


@Configuration
public class ConfigCron {


    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(4); //TODO вынести в параметры

        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler-"); //TODO вынести в параметры
        return threadPoolTaskScheduler;
    }
}
