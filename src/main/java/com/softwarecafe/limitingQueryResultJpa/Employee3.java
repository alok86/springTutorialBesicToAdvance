package com.softwarecafe.limitingQueryResultJpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee3 {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String dept;
    private int salary;
}
