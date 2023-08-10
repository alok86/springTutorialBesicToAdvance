package com.softwarecafe.jpaProjections.beans;

import lombok.*;

import java.util.Objects;

// this bean is based on model Artisan
@Getter
@Setter

public class ArtisanInfo {

    private String name;
    private int salary;

    public ArtisanInfo(String name , int salary)
    {
        this.name=name;
        this.salary=salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ArtisanInfo that = (ArtisanInfo) o;
        return salary == that.salary &&
                Objects.equals(name, that.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
