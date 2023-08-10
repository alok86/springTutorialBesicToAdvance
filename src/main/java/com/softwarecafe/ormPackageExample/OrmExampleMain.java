package com.softwarecafe.ormPackageExample;

import com.softwarecafe.ormPackageExample.config.HibernateConfig;
import com.softwarecafe.ormPackageExample.model.Employee;
import com.softwarecafe.ormPackageExample.service.EmployeeService;
import com.softwarecafe.ormPackageExample.service.EmployeeServiceImpl;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OrmExampleMain {
    //final static Logger logger = Logger.getLogger(OrmExampleMain.class);
    @Autowired
    private EmployeeService empService;

    public void setEmpService() {
        this.empService = new EmployeeServiceImpl();
    }


    public void performDbTasks()
    {
        this.setEmpService();
        Employee empNew = new Employee(1l, "Bytes", "Tree", "Senior Developer", 2000);

        // Save new employee
        empService.addNewEmployee(empNew);

        // Get saved employee
        Employee employee = empService.getEmployee(empNew.getId());
        //logger.debug("Retrieving saved employee " + employee);
        System.out.println("Retriving Saved Employee"+ employee);

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(HibernateConfig.class);
        context.refresh();
        OrmExampleMain oxm = new OrmExampleMain();
        oxm.performDbTasks();
    }
}
