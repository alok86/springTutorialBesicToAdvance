package com.softwarecafe.springDataJpaEnablingTransactions.repository;

import com.softwarecafe.springDataJpaEnablingTransactions.model.Worker;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface WorkerRepositoryModifyQuery extends CrudRepository<Worker,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Worker e SET e.salary = e.salary + :increaseBy")
    int increaseSalaries(@Param("increaseBy") int increaseBy);

    @Transactional
    @Modifying
    @Query("UPDATE Worker e SET e.salary = e.salary + e.salary * :byPercent/100 WHERE e.dept = :dept")
    int updateDeptSalaries(@Param("dept") String dept, @Param("byPercent") int byPercent);

    @Transactional
    @Modifying
    int deleteByNameAndDept(String name, String dept);

    @Transactional
    @Modifying
    int deleteBySalaryGreaterThanEqual(int salary);
}
