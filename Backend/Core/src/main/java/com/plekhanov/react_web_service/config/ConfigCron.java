package com.plekhanov.react_web_service.config;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;


@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConfigCron {


    Integer poolSize;
    String threadNamePrefix;

    public ConfigCron(@Value("${taskExecutor.poolSize}") Integer poolSize,
                      @Value("${taskExecutor.threadNamePrefix}") String threadNamePrefix) {
        this.poolSize = poolSize;
        this.threadNamePrefix = threadNamePrefix;
    }


    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(poolSize);

        threadPoolTaskScheduler.setThreadNamePrefix(threadNamePrefix);
        return threadPoolTaskScheduler;
    }
}
