package com.softwarecafe.jpaPagingSorting;

import com.softwarecafe.jpaPagingSorting.service.ExmplClient;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PagingMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ExmplClient exampleClient = context.getBean(ExmplClient.class);
        exampleClient.run();
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }
}
