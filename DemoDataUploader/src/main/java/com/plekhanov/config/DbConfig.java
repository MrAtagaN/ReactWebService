package com.plekhanov.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class DbConfig {



    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;


    @Bean("SQLite")
    public DataSource getDataSourceSqLite() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }

    /**
     * Заглушка для {@link FlywayMigrationInitializer}, ничего не делает
     */
    @Bean
    public FlywayMigrationInitializer getFlywayMigrationInitializer() {
        return new FlywayMigrationInitializer(new Flyway(), (f) ->{} );

    }


}
