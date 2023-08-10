package com.softwarecafe.limitingQueryResultJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService2 {
    @Autowired
    private EmployeeRepository2 repo;
    public void serve(){
        System.out.println(" -- finding all employees --");
        Iterable<Employee3> all = repo.findAll();
        all.forEach(System.out::println);

        System.out.println(" -- finding employee with name like %ana --");
        List<Employee3> list = repo.findByNameLike("%ana");
        list.forEach(System.out::println);

        System.out.println(" -- finding employee with name like %a_a --");
        list = repo.findByNameLike("%a_a");
        list.forEach(System.out::println);

        System.out.println(" -- finding employee with dept name more than 3 chars --");
        list = repo.findByDeptLike("___%");
        list.forEach(System.out::println);

    }
}
