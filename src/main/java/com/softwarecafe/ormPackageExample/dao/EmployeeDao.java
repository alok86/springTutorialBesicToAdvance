package com.softwarecafe.ormPackageExample.dao;

import com.softwarecafe.ormPackageExample.model.Employee;

import java.io.Serializable;

public interface EmployeeDao {
    Serializable save(Employee employee);
    Employee findById(Serializable id);
}
