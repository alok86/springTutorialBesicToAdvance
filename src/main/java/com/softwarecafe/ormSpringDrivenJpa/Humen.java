package com.softwarecafe.ormSpringDrivenJpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Humen {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String address;

    public static Humen create(String firstName,String lastName,String address)
    {
        Humen humen = new Humen();
        humen.setFirstName(firstName);
        humen.setLastName(lastName);
        humen.setAddress(address);
        return humen;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Humen{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
