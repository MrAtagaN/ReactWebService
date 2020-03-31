package com.plekhanov.react_web_service.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

import static org.hibernate.cfg.AvailableSettings.*;


@Configuration
public class DbConfig {

    /**
     * SessionFactory
     */
    @Bean
    public SessionFactory getSessionFactory(DataSource getDataSource) {

        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
                .applySetting(DIALECT, "org.hibernate.dialect.SQLiteDialect")
                .applySetting(HBM2DDL_AUTO, "validate")
                .applySetting(DATASOURCE, getDataSource);

        StandardServiceRegistry registry = standardServiceRegistryBuilder.build();

        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
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