package com.plekhanov.react_web_service.config;

import com.plekhanov.react_web_service.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import static org.hibernate.cfg.AvailableSettings.*;

/**
 * Конфиг подключения к базе данных
 */
@Configuration
public class DbConfig {

    /**
     * Создает бин {@link SessionFactory}, он должен создаваться после бина {@link FlywayMigrationInitializer}
     */
    @Bean
    public SessionFactory getSessionFactory(DataSource getDataSource, FlywayMigrationInitializer flywayMigrationInitializer) {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(User.class);

        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
                .applySetting(DIALECT, "org.hibernate.dialect.SQLiteDialect")
                .applySetting(HBM2DDL_AUTO, "validate")
                .applySetting(DATASOURCE, getDataSource)
                .applySettings(configuration.getProperties());

        StandardServiceRegistry registry = standardServiceRegistryBuilder.build();
        return configuration.buildSessionFactory(registry);
    }

    //    @Bean
//    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager manager = new HibernateTransactionManager();
//        manager.setSessionFactory(sessionFactory);
//        return manager;
//    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource getDataSource) {
        return new JdbcTemplate(getDataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataSource getDataSource) {
        return new NamedParameterJdbcTemplate(getDataSource);
    }
}