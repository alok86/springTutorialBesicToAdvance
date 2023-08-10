package com.softwarecafe.ormDAOinJPA2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "alien")
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String firstName;

    @Column(name = "last_name")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String lastName;

    @Column(name = "address")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Alien create(String firstName, String lastName, String address) {
        Alien person = new Alien();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAddress(address);
        return person;
    }
}
