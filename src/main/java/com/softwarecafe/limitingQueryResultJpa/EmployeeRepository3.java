package com.softwarecafe.limitingQueryResultJpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository3 extends CrudRepository<Employee3,Long> {
    long countByDept(String deptName);
    long countBySalaryGreaterThanEqual(int salary);
    long countByNameEndingWith(String endString);
    long countByNameLike(String likeString);
}
