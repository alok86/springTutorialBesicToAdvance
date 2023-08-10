package com.softwarecafe.springDataJpaEnablingTransactions;

import com.softwarecafe.springDataJpaEnablingTransactions.service.ClientOfModifyQuery;
import com.softwarecafe.springDataJpaEnablingTransactions.service.ExampleClient;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WorkerMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        ExampleClient client = context.getBean(ExampleClient.class);
//        try {
//            client.saveWorker();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        client.findWorkers();


        ClientOfModifyQuery client = context.getBean(ClientOfModifyQuery.class);
        client.run();

        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }
}
