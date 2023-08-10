package com.softwarecafe.limitingQueryResultJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService3 {
    @Autowired
    private EmployeeRepository3 repo;
    public void serve(){
        System.out.println(" -- finding the employee count in IT dept --");
        long count = repo.countByDept("IT");
        System.out.println(count);

        System.out.println(" -- finding the employee count with salary greater or equal to 4000 --");
        count = repo.countBySalaryGreaterThanEqual(4000);
        System.out.println(count);

        System.out.println(" -- finding the employee count with name ending with 'e' --");
        count = repo.countByNameEndingWith("e");
        System.out.println(count);

        System.out.println(" -- finding the employee count with name like '%a_a' --");
        count = repo.countByNameLike("%a_a");
        System.out.println(count);

    }
}
