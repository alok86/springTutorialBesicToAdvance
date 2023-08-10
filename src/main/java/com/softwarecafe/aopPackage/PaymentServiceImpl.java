package com.softwarecafe.aopPackage;

public class PaymentServiceImpl implements PaymentService{
    @Override
    public void makePayment() {
        System.out.println("amount debited .....");


        System.out.println("amounted credited...");
    }
}
