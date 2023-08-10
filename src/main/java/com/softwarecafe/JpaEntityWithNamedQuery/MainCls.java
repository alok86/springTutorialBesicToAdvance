package com.softwarecafe.JpaEntityWithNamedQuery;

import com.softwarecafe.jpaPagingSorting.AppConfig;
import com.softwarecafe.jpaPagingSorting.service.ExmplClient;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainCls {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ExmplClient bean = context.getBean(ExmplClient.class);
        bean.run();
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }
}
