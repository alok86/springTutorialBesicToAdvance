package com.softwarecafe.ormPackageExample;

import com.softwarecafe.ormPackageExample.config.AppConfiguration;
import com.softwarecafe.ormPackageExample.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class OrmAnotherMain {

    public static void main(String... args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        try{
            nativeQuery(emf,"SHOW TABLES");
            nativeQuery(emf,"SHOW COLUMNS from EMPLOYEE1");
            Employee emp = new Employee(1101L,"Anshuman","Dixit","Asst.Prof",50000);
            persistEntity(emf,emp);
            nativeQuery(emf,"SELECT * FROM EMPLOYEE1");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("exception run");
        }
        finally {
            emf.close();
            System.out.println("finally run");
        }
    }

    private static void persistEntity(EntityManagerFactory emf, Employee emp) {
        System.out.println("-------------");
        System.out.println("Persisting Employee: "+emp);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(emp);
        System.out.println("run...... after persist");
        em.getTransaction().commit();
        System.out.println("run ...... after commit");
        em.close();
        System.out.println("run...... after close");
    }

    private static void nativeQuery(EntityManagerFactory emf, String s) {
        EntityManager em = emf.createEntityManager();
        System.out.printf("--------------------%n'%s'%n",s);
        Query query = em.createNativeQuery(s);
        List list = query.getResultList();
        for (Object o:list){
            if(o instanceof Object[])
            {
                System.out.println(Arrays.toString((Object[])o));
            }else {
                System.out.println(o);
            }
        }
        em.close();
    }
}
