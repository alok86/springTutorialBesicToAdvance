package com.softwarecafe.aopPackage;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvisor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object obj;
        System.out.println("Additional Concern before actual logic");
        obj = methodInvocation.proceed();
        System.out.println("additional concern after actual logic");

        return obj;
    }
}
