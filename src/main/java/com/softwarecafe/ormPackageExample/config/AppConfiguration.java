package com.softwarecafe.ormPackageExample.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfiguration {
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.driver-class.name}")
    private String driverClassName;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public LocalContainerEntityManagerFactoryBean factoryBean(){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(this.mysqlDatasource());
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setPersistenceXmlLocation("JPA/my-persistence.xml");
        factory.setJpaProperties(this.databaseproperties());
        return factory;
    }

    public Properties databaseproperties()
    {
       Properties properties = new Properties();
       properties.setProperty("javax.persistence.schema-generation.database.action", "update");
       return properties;
    }
    @Bean
    public DataSource mysqlDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(jdbcUrl,username,password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

}
