package com.softwarecafe.dataJpaUsingSpELExpression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpRepository repo;

    public void run() {
        List<Employee4> employees = createEmployees();
        repo.saveAll(employees);

        System.out.println(" -- finding all employees --");
        Iterable<Employee4> all = repo.findAll();
        all.forEach(System.out::println);

        System.out.println(" -- finding by dept Admin --");
        List<Employee4> list = repo.findByDepartment("Admin");
        list.forEach(System.out::println);
    }

    private List<Employee4> createEmployees() {
        return Arrays.asList(
                new Employee4(1L, "Diana", "Admin", 2000),
                new Employee4(1L, "Mike", "Sale", 1000),
                new Employee4(1L, "Rose", "IT", 4000),
                new Employee4(1L, "Sara", "Admin", 3500),
                new Employee4(1L, "Randy", "Sale", 3000),
                new Employee4(1L, "Charlie", "IT", 2500)
        );
    }
}

