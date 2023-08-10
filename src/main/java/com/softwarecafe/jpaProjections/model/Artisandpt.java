package com.softwarecafe.jpaProjections.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "artisandpt")
@ToString
public class Artisandpt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;


    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @Column(name = "salary")
    private int salary;

    public static Artisandpt of(String name, Department dept, int salary) {
        Artisandpt e = new Artisandpt();
        e.setName(name);
        e.setDepartment(dept);
        e.setSalary(salary);
        return e;
    }
}