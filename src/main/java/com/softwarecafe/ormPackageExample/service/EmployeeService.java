package com.softwarecafe.ormPackageExample.service;

import com.softwarecafe.ormPackageExample.model.Employee;

public interface EmployeeService {
    Employee getEmployee(Long id);

    void addNewEmployee(Employee employee);
}
