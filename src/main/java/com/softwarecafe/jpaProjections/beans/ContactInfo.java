package com.softwarecafe.jpaProjections.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInfo {
    private String name;
    private String phone;

    public ContactInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
