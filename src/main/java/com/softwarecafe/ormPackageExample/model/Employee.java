package com.softwarecafe.ormPackageExample.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee1")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private static final long serialVersionUID = 4910225916550731446L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstname;
    private String lastname;
    private String designation;
    private Integer salary;



}