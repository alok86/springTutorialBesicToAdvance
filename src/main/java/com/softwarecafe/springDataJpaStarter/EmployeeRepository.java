package com.softwarecafe.springDataJpaStarter;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<AnotherEmployee , Long> {
    /*CrudRepository Already provide some basic methods such as save , findById,
    * you can check all method by placing carat at CrudRepository and pressig ctrl Q
    * or click at CrudRepository by ctrl key
    *  following methods are additional method which implementation create automatically
    *  but necessary to follow method naming convention*/
    List<AnotherEmployee> findByDept(Dept dept);
       List<AnotherEmployee> findByDeptName(String deptName);

       List<AnotherEmployee> findBySalaryGreaterThan(int salary);
       List<AnotherEmployee> findByDeptAndSalaryLessThan(String deptName , int salary);


}
