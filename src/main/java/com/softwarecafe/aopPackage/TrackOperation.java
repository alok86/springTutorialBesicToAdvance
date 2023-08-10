package com.softwarecafe.aopPackage;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
//import org.jetbrains.annotations.NotNull;

//for XML Based configuration , There is no need to annotate
// marker will be taken care by xml file itself

//@Aspect
public class TrackOperation {
//    @Pointcut("execution(* Operation.*(..))")
//    public  void k(){
//        System.out.println("it is for Track Operation k()");
//    }//pointcut name
//
//    @Before("k()")
    public void myadvice(JoinPoint jp)//it is the advice before advice
    {

        System.out.println("aditional concern");
        System.out.println("Method signature:"+jp.getSignature());
    }
//    @After("k()")
//    public void afterAdvice(JoinPoint joinPoint)
//    {
//        System.out.println("The task will execute after invoking the method");
//    }

//    @AfterReturning(pointcut = "execution(* Operation.*(..))",returning = "result")
//    public void myAdvice(JoinPoint joinPoint,Object result)// It is advice after returning advice
//    {
//        System.out.println("additional concern");
//        System.out.println("Method Signature"+ joinPoint.getSignature());
//        System.out.println("result in advice"+result);
//        System.out.println("end of returing advice");
//    }
//    @Pointcut("execution(* Operation.*(..))")
//    public void abcPointcut(){}
//
//    @Around("abcPointcut()")
//    public Object myAdvice(ProceedingJoinPoint pjp) throws Throwable
//    {
//        System.out.println("Additional concern Before calling actual method");
//
//        Object obj = pjp.proceed();
//
//        System.out.println("Additional concern after actual method");
//        return obj;
//    }

}
