package com.softwarecafe.aopPackage;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TrackValidator {
    @AfterThrowing(
            pointcut = "execution(* validator.*(..))",
            throwing = "error"
    )
    public  void myAdvice(JoinPoint joinPoint,Throwable error)
    {
        System.out.println("additional concern");
        System.out.println("Method Signature "+ joinPoint.getSignature());
        System.out.println("Exception is "+error);
        System.out.println("end of after Throwing advice");
    }
}
