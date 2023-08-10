package com.softwarecafe.ormDAOinJPA2;

import com.softwarecafe.ormDAOinJPA2.client.ExampleClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;


//@ComponentScan
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ExampleClient client = (ExampleClient) context.getBean("client");
        client.run();

        context.getBean(LocalEntityManagerFactoryBean.class).destroy();
    }
}
