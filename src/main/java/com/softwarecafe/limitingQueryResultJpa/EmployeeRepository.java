package com.softwarecafe.limitingQueryResultJpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee3,Long> {
    Employee3 findTopByOrderBySalaryDesc();
    Employee3 findTopByOrderBySalaryAsc();
    List<Employee3> findTop3ByOrderBySalaryDesc();
    List<Employee3> findTop3ByOrderBySalaryAsc();
    List<Employee3> findFirst2BySalary(int salary);
    List<Employee3> findFirst2ByDeptOrderBySalaryDesc(String deptName);
}
