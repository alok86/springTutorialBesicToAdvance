package com.softwarecafe.iocPackage;

public class Bike implements Vehical{
    private String model;
    private String brand;

    public Bike() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }



    @Override

    public void drive() {
        System.out.println(this.toString()+"Bag raha hai");
    }

    @Override
    public String toString() {
        return "My Bike " +
                "of " + brand + "of " +
                 model+"\t";
    }
}
