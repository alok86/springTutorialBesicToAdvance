package com.softwarecafe.iocPackage;

public class Tempo implements Vehical{
    String brand ;
    String type ;

    public Tempo(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    @Override
    public void drive() {
        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        return "Tempo of " + brand  +
                " which is " + type + "is running";
    }
}
