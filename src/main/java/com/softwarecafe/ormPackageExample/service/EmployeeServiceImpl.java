package com.softwarecafe.ormPackageExample.service;

import com.softwarecafe.ormPackageExample.dao.EmployeeDao;
import com.softwarecafe.ormPackageExample.dao.EmployeeDaoImpl;
import com.softwarecafe.ormPackageExample.model.Employee;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService{
   // final static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

    @Autowired
    EmployeeDao employeeDao;
   public EmployeeServiceImpl()
   {
       employeeDao = new EmployeeDaoImpl();
   }


    @Override
    public Employee getEmployee(Long id) {
        //logger.debug("Getting employee with id " + id);
        System.out.println("Getting employee with id " + id);
        return employeeDao.findById(id);
    }
    /**
     * Add new employee
     *
     * @param employee:
     *            Employee to add
     */
    @Override
    @Transactional(readOnly = false)
    public void addNewEmployee(Employee employee) {
        Long id = (Long) employeeDao.save(employee);
        //logger.debug("Id of new Employee " + id);
        System.out.println("Id of new Employee " + id);
    }
}
