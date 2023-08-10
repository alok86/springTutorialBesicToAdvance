package com.softwarecafe.ormtwo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import java.util.Arrays;
import java.util.List;

/*
*
Spring JPA Support with LocalEntityManagerFactoryBean
[Last Updated: Nov 23, 2017]

Spring provides ORM (JPA, Hibernate etc) support in it's spring-orm module. In this tutorial,
* we will see one of the ways to use JPA in spring application. Spring's LocalEntityManagerFactoryBean can be
* used to register JPA EntityManagerFactory as a bean. This method of loading JPA factory is according to JPA's
* standard standalone bootstrap contract.

Example
In following example, we are going to use Hibernate as a JPA provider.
* */

@Configuration
public class OrmTwoMain {

    @Bean
    public LocalEntityManagerFactoryBean localEntityManagerFactoryBean()
    {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("example-unit");
        return  factoryBean;
    }
    private static void nativeQuery(EntityManager em, String s) {
        System.out.printf("---------------------------%n'%s'%n", s);
        Query query = em.createNativeQuery(s);
        List list = query.getResultList();
        for (Object o : list) {
            if (o instanceof Object[]) {
                System.out.println(Arrays.toString((Object[]) o));
            } else {
                System.out.println(o);
            }
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(OrmTwoMain.class);
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();
        try {
            nativeQuery(em, "SHOW TABLES");
            nativeQuery(em, "SHOW COLUMNS from PersonNew");

        } finally {
            em.close();
            emf.close();
        }
    }
}
