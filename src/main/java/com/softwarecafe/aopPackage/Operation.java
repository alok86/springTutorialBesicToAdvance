package com.softwarecafe.aopPackage;

public class Operation {
    public Operation(){}
    public void msg(){
        System.out.println("msg method invoked");
    }
    public int m(){
        System.out.println("m method is invoked");
        return 2;
    }
    public int k(){
        System.out.println("k method is invoked");
        return 3;
    }
}
