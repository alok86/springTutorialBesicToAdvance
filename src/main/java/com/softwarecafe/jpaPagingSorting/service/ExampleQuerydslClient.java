package com.softwarecafe.jpaPagingSorting.service;


import com.softwarecafe.jpaPagingSorting.repository.EmplQuerydslReposotory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleQuerydslClient {
    private EmplQuerydslReposotory repo;
    public void run(){
        System.out.println("Employee having salary greater than 3000 order by salary");

    }
}
