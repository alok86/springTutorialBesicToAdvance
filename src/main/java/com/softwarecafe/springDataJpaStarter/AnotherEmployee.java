package com.softwarecafe.springDataJpaStarter;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnotherEmployee {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    @ManyToOne(cascade= CascadeType.ALL)
    private Dept dept;
    //private String dept;

    private int salary;
}
