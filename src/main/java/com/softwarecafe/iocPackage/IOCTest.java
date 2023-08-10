package com.softwarecafe.iocPackage;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
    public static void main(String[] args) {
 //       ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        Vehical vehical = (Vehical) context.getBean("tempo");
//        vehical.drive();

//        Employee e = (Employee) context.getBean("employee");
//        e.show();
//        System.out.println(e);

//        Question q = (Question) context.getBean("qus");
//        q.displayInfo();
//        Question2 q = (Question2) context.getBean("qus2");
//        q.displayInfo();
//        Question3 q = (Question3) context.getBean("q");
//        q.displayInfo();

//        Employee e = (Employee) context.getBean("e2");
//        e.show();
//            Student s =(Student) context.getBean("stu");
//        System.out.println(s);
//          IICCell cell = (IICCell) context.getBean("iic");
//        System.out.println( cell.toString());
//        A a = context.getBean("a",A.class);
//        a.display();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfiguration.class);
        context.refresh();
        Product p  = (Product) context.getBean("pro");
        //p.setId(101);
        //p.setName("samsung phone");
        System.out.println(p.toString());
    }
}
