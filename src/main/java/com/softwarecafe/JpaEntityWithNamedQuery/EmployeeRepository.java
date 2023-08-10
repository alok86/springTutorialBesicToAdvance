package com.softwarecafe.JpaEntityWithNamedQuery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee5,Long> {
    public List<Object[]> findMaxSalariesByDept(List<String> deptNames);
}
