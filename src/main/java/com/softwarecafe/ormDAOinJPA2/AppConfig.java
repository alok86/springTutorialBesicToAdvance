package com.softwarecafe.ormDAOinJPA2;

import com.softwarecafe.ormDAOinJPA2.client.ExampleClient;
import com.softwarecafe.ormDAOinJPA2.dao.AlienDaoJpaImpl;
import com.softwarecafe.ormDAOinJPA2.service.AlienService;
import com.softwarecafe.ormDAOinJPA2.service.AlienServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class AppConfig {
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory(){
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("example-unit");
        return factoryBean;
    }


    @Bean("client")
    public ExampleClient client(){
        ExampleClient exampleClient = new ExampleClient();
        return exampleClient;
    }
    @Bean
    public AlienServiceImpl alienService(){
        AlienServiceImpl alienService = new AlienServiceImpl();
        return alienService;
    }
    @Bean
    public AlienDaoJpaImpl alienDaoJpa()
    {
        AlienDaoJpaImpl daoJpa = new AlienDaoJpaImpl();
        return daoJpa;
    }
}
