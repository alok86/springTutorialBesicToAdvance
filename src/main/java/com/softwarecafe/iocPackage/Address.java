package com.softwarecafe.iocPackage;

public class Address {
    private String houseno;
    private String locality;
    private String pincode;

    public Address(String houseno, String locality, String pincode) {
        this.houseno = houseno;
        this.locality = locality;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseno='" + houseno + '\'' +
                ", locality='" + locality + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
