package com.softwarecafe.jpaProcedureAnnotation;

import com.softwarecafe.jpaProcedureAnnotation.service.ExampleClient;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ExampleClient exampleClient = context.getBean(ExampleClient.class);
        exampleClient.run();
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }
}
