package com.softwarecafe.dataJpaUsingSpELExpression;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "empl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee4 {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String dept;
    private int salary;
}
