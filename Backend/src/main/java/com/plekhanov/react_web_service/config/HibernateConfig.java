package com.plekhanov.react_web_service.config;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class HibernateConfig {


    /**
     *
     */
    @Bean
    public SessionFactory getSessionFactory(DataSource getDataSource) {

        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
                .applySetting(Environment.DIALECT, "org.hibernate.dialect.SQLiteDialect")
                .applySetting(Environment.HBM2DDL_AUTO, "validate")
                .applySetting(Environment.DATASOURCE, getDataSource);


        StandardServiceRegistry registry = standardServiceRegistryBuilder.build();

        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


//    @Bean
//    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager manager = new HibernateTransactionManager();
//        manager.setSessionFactory(sessionFactory);
//        return manager;
//    }


}
