package com.softwarecafe.aopPackage;

import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class AopMain {
    public static void main(String[] args) {

        //*****************section 3**************************
       /* AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
      context.register(AopConfiguration.class);
       context.refresh();*/
////        ABC a = (ABC) context.getBean("demo");
////        a.showMsg();
//        PaymentService paymentService = (PaymentService) context.getBean("pay");
//        paymentService.makePayment();
// *************************section 1******************************************
 //       Resource r = new ClassPathResource("contextaop.xml");
 //       BeanFactory factory = new XmlBeanFactory(r);
 //********************************************************
//        A a =factory.getBean("proxy",A.class);
//        System.out.println("proxy class name"+a.getClass().getName());
//        a.m();
//   **     validator v = factory .getBean("proxy",validator.class);
//        try {
//            v.validate(21);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//
//    **    }
//*********************************section 2*******************
     //   ApplicationContext context = new ClassPathXmlApplicationContext("contextaopanno.xml");
       // Operation e = (Operation) context.getBean("opBean");
//        System.out.println("calling msg");
//        e.msg();
//        System.out.println("calling m");
//        System.out.println("m from main "+e.m());
//        System.out.println("calling k");
//        System.out.println("k from main "+ e.k());
       // e.msg();
/*
* in this main there is 3 way of configuration
* 1 . dtd old styple configuration for see section 1
* 2. annotation based configuration , see section 2
* 3. annotation without using any xml file using aopConfiguration class ,section 3
* 4. xml configuration based
* */
        //********************section 3********************
//        validator vd = (validator) context.getBean("vd");
//        try {
//            vd.validate(22);
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
        ApplicationContext context = new ClassPathXmlApplicationContext("contextaopxmlconfig.xml");
        Operation e = (Operation) context.getBean("opBean");
        System.out.println("calling msg...");
        e.msg();
        System.out.println("calling m...");
        e.m();
        System.out.println("calling k...");
        e.k();

    }

}
