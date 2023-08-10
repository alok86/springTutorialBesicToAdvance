package com.softwarecafe.usingSpELGenericRepositiry;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GenericMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ExampleClient client = context.getBean(ExampleClient.class);
        client.run();
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }
}
