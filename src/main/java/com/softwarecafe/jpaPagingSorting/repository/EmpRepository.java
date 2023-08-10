package com.softwarecafe.jpaPagingSorting.repository;

import com.softwarecafe.jpaPagingSorting.model.Employee6;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpRepository extends CrudRepository<Employee6,Long> {
    public List<Employee6> findByDept(String deptName, Sort sort);
    public Page<Employee6> findByDept(String deptName, Pageable pageable);

}
