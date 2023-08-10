package com.softwarecafe.dataJpaUsingSpELExpression;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends CrudRepository<Employee4,Long> {
    @Query("SELECT e FROM #{#entityName} e WHERE e.dept=?1")
    public List<Employee4> findByDepartment(String deptName);
}
