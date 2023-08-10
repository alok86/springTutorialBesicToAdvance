package com.softwarecafe.limitingQueryResultJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;
    public void run(){
        List<Employee3> employees = createEmployees();
        repo.saveAll(employees);

        System.out.println("----------Finding All Employees");
        Iterable<Employee3> allEmployee = repo.findAll();
        allEmployee.forEach(System.out::println);

        System.out.println(" -- finding the employee with max salary --");
        Employee3 emp = repo.findTopByOrderBySalaryDesc();
        System.out.println(emp);

        System.out.println(" -- finding the employee with min salary --");
        emp = repo.findTopByOrderBySalaryAsc();
        System.out.println(emp);

        System.out.println(" -- finding the top 3 employees with max salary --");
        List<Employee3> list = repo.findTop3ByOrderBySalaryDesc();
        list.stream().forEach(System.out::println);

        System.out.println(" -- finding the top 3 employees with min salary --");
        list = repo.findTop3ByOrderBySalaryAsc();
        list.stream().forEach(System.out::println);

        System.out.println(" -- finding the first 2 employees with salary 3000 --");
        list = repo.findFirst2BySalary(3000);
        list.stream().forEach(System.out::println);

        System.out.println(" -- finding the top 2 employees with max salary in IT dept --");
        list = repo.findFirst2ByDeptOrderBySalaryDesc("IT");
        list.stream().forEach(System.out::println);
    }

    private List<Employee3> createEmployees() {
        return Arrays.asList(new Employee3(1L,"Atul","Admin",5000),
                new Employee3(2L,"Shraya","HR",3000),
                new Employee3(3L,"Saksham","IT",4000),
                new Employee3(4L,"Anand","sale",3000),
                new Employee3(5L,"kshama","IT",4000),
                new Employee3(6L,"Abhinav","HR",3000));
    }
}
