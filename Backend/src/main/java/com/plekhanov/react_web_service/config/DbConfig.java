package com.plekhanov.react_web_service.config;

import com.plekhanov.react_web_service.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static org.hibernate.cfg.AvailableSettings.*;

/**
 * Конфиг подключения к базе данных
 */
@Configuration
public class DbConfig {

    @Value("${hibernate.dialect}")
    private String sqlDialect;

    /**
     * Создает бин {@link SessionFactory}, он должен создаваться после бина {@link FlywayMigrationInitializer},
     * чтобы Flyway сначала создал таблицы, а потом Hibernate к ним подключился
     */
    @Bean
    public SessionFactory getSessionFactory(final DataSource getDataSource, final FlywayMigrationInitializer flywayMigrationInitializer) {
        final org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(UserBagProduct.class);
        configuration.addAnnotatedClass(UserFavoriteProduct.class);
        configuration.addAnnotatedClass(ProductType.class);

        final StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
                .applySetting(DIALECT, sqlDialect)
                .applySetting(HBM2DDL_AUTO, "validate")
                .applySetting(DATASOURCE, getDataSource)
                .applySettings(configuration.getProperties());

        final StandardServiceRegistry registry = standardServiceRegistryBuilder.build();
        return configuration.buildSessionFactory(registry);
    }


}
