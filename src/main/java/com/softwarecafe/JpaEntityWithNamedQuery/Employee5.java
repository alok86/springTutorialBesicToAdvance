package com.softwarecafe.JpaEntityWithNamedQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Employee5.findMaxSalariesByDept",
query = "SELECT e.dept , MAX(e.salary)FROM Employee5 e GROUP BY e.dept HAVING e.dept in ?1")
@ToString
public class Employee5 {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String dept;
    private int salary;
}
