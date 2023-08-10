package com.softwarecafe.jdbcPackage;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Userdata {
    private int id;
    private String username;
    private String password;
}
