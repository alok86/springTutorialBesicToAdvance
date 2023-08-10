package com.softwarecafe.springDataJpaEnablingTransactions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "worker")
@ToString
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "dept")
    private String dept;

    @Column(name = "salary")
    private Integer salary;

    public static Worker create(String name, String dept, int salary) {
        Worker e = new Worker();
        e.setName(name);
        e.setDept(dept);
        e.setSalary(salary);
        return e;
    }
}