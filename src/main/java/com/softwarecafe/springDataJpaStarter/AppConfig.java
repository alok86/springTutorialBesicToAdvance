package com.softwarecafe.springDataJpaStarter;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.Metamodel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Map;

@Configuration
@ComponentScan
@EnableJpaRepositories
public class AppConfig {
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("db2-unit");
        return emf;
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }
}

