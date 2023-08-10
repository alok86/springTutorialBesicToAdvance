package com.softwarecafe.jpaPagingSorting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee6 {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String dept;
    private int salary;
    public static Employee6 create(String name, String dept, int salary) {
        Employee6 e = new Employee6();
        e.setName(name);
        e.setDept(dept);
        e.setSalary(salary);
        return e;
    }
}
