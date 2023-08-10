package com.softwarecafe.iocPackage;

public class Employee {
    private String id;
    private String name;
    private Address address;

    // code start form here is required for bean decelaration of e1 and e1
    public Employee(){}
    public Employee(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    // End here
    public Employee(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void show(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Employee{\n" +
                "id=" + id +
                ",\n name='" + name + '\'' +
                ",\n address=" + address +
                '}';
    }
}
