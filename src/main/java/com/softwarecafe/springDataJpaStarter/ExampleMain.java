package com.softwarecafe.springDataJpaStarter;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


public class ExampleMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProxyClient client = context.getBean(ProxyClient.class);
        client.run();
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }
}
