package com.softwarecafe.ormSpringDrivenJpa;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class HumenMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.getBean(Client.class).run();
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }

}
