package com.softwarecafe.ormPackageExample.dao;

import com.softwarecafe.ormPackageExample.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Serializable save(Employee employee) {
        return (Serializable) getSession().save(employee);
    }

    @Override
    public Employee findById(Serializable id) {
        return getSession().get(Employee.class,id);
    }
}
