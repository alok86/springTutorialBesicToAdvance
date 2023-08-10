package com.softwarecafe.aopPackage;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

//There are given examples of Spring1.2 old style AOP (dtd based) implementation.
public class BeforeAdvisor implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
//        System.out.println("additional concern before actual logic");
        System.out.println("additional concern before actual logic");
        System.out.println("method info:"+method.getName()+" "+method.getModifiers());
        System.out.println("argument info:");
        for(Object arg:args)
            System.out.println(arg.getClass().getName());
        System.out.println("target Object:"+target);
        System.out.println("target object class name: "+target.getClass().getName());


    }
}
