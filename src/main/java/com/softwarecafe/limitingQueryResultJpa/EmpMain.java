package com.softwarecafe.limitingQueryResultJpa;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        EmployeeService service = context.getBean(EmployeeService.class);
//        service.run();
//        EmployeeService2 service = context.getBean(EmployeeService2.class);
//        service.serve();
        EmployeeService3 service = context.getBean(EmployeeService3.class);
        service.serve();

        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }
}
