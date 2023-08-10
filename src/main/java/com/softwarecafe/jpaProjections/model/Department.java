package com.softwarecafe.jpaProjections.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "department")
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "location")
    private String location;

    @Column(name = "dept_name")
    private String deptName;

    public static Department of(String name, String location){
        Department d = new Department();
        d.setDeptName(name);
        d.setLocation(location);
        return d;
    }
}