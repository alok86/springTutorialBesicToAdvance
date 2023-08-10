package com.softwarecafe.JpaEntityWithNamedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    //private EmployeeRepository repo;
    private EmployeeRepository2 repo;

    public void run() {
        List<Employee5> employees = createEmployees();
        repo.saveAll(employees);

        System.out.println(" -- finding all employees --");
        Iterable<Employee5> all = repo.findAll();
        all.forEach(System.out::println);

        System.out.println(" -- finding max salaries in Admin and IT depts --");

        List<Object[]> list =repo.findMaxSalariesByDept(Arrays.asList("Admin","IT"));
        list.forEach(arr-> System.out.println(Arrays.toString(arr)));

    }
    private List<Employee5> createEmployees() {
        return Arrays.asList(
                new Employee5(1L,"Diana", "Admin", 2000),
                new Employee5(2L,"Mike", "Sale", 1000),
                new Employee5(3L,"Rose", "IT", 4000),
                new Employee5(4L,"Sara", "Admin", 3500),
                new Employee5(5L,"Randy", "Sale", 3000),
                new Employee5(6L,"Charlie", "IT", 2500)
        );
    }
}
