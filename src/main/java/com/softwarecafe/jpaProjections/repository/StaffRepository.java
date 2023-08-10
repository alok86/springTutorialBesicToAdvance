package com.softwarecafe.jpaProjections.repository;

import com.softwarecafe.jpaProjections.model.Staff;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StaffRepository extends CrudRepository<Staff,Long> {
    <T>List<T> findByDept(String dept, Class<T>type);
}
