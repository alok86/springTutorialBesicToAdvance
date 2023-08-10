package com.softwarecafe.dataJpaUsingSpELExpression;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmpService empService = (EmpService) context.getBean("empService");
        empService.run();
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();

    }
}
