package com.softwarecafe.aopPackage;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsAdvisor implements ThrowsAdvice {
    public void afterThrowing(Exception exception)
    {
        System.out.println("additional concern if exception is occurs");
    }
}
