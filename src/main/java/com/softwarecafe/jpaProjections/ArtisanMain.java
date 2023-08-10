package com.softwarecafe.jpaProjections;

import com.softwarecafe.jpaProjections.service.*;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ArtisanMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        //ArtisanClient exampleClient = context.getBean(ArtisanClient.class);
//        ArtisandptClient2 exampleClient = context.getBean(ArtisandptClient2.class);
//        ArtisanClassBasedClient exampleClient = context.getBean(ArtisanClassBasedClient.class);
        StaffService exampleClient = context.getBean(StaffService.class);
        exampleClient.run();
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }
}
