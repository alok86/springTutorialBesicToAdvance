package com.softwarecafe.jpaProjections.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SalaryInfo {
    private String name;
    private int salary;

    public SalaryInfo(String name,int salary){
        this.name = name;
        this.salary=salary;
    }
}
