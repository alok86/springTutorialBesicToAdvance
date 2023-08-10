package com.softwarecafe.limitingQueryResultJpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository2 extends CrudRepository<Employee3,Long> {
    List<Employee3> findByNameLike(String likeString);
    List<Employee3> findByDeptLike(String likeString);
}
