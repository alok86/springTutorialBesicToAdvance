package com.softwarecafe.aopPackage;

public class validator {

    public void validate(int age) throws Exception
    {
        if(age<18)
            throw new ArithmeticException("not vaid age");
      else
        System.out.println("vote confirmed");
    }
}
