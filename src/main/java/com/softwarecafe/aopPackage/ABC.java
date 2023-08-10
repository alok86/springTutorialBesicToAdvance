package com.softwarecafe.aopPackage;

import org.springframework.stereotype.Component;

@Component
public class ABC {
    public void showMsg(){
        System.out.println("it is just to test Aop Configuration running properly");
    }
}
