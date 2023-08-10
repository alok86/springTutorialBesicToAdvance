package com.softwarecafe.springDataJpaStarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ProxyClient {
    @Autowired
    private EmployeeRepository repo;
    @Autowired
    private DeptRepository drepo;

    public void run (){
        List<AnotherEmployee> employees = createEmployees();

        System.out.println("------ Saving Employees__________");
        System.out.println(employees);
        repo.saveAll(employees);

//        System.out.println("-------Saving Departments------------");
//        List<Dept> depts = createDepts();
//        drepo.saveAll(depts);

        System.out.println("________Finding All Employees_________");
        Iterable<AnotherEmployee> allEmployee = repo.findAll();
        allEmployee.forEach(System.out::println);

//        if (repo.existsById(1L)) {
//            System.out.println("-- finding by id --");
//            Optional<AnotherEmployee> employeeOptional = repo.findById(1L);
//            AnotherEmployee employee = employeeOptional.orElseThrow(RuntimeException::new);
//            System.out.println(employee);
//
//            System.out.println("-- deleting --");
//            System.out.println(employee);
//            repo.delete(employee);
//        }
//
//        if (repo.existsById(2L)) {
//            System.out.println("-- updating --");
//            AnotherEmployee employee2 = repo.findById(2L).orElseThrow(RuntimeException::new);
//            System.out.println(employee2);
//            employee2.setDept("IT");
//            repo.save(employee2);
//        }
        System.out.println(" -- finding by dept name IT --");
        List<AnotherEmployee> list = repo.findByDeptName("IT");
        list.stream().forEach(System.out::println);

        System.out.println("--------Find by Dept entity Admin--------");
        Dept admin = drepo.findByName("Admin");
        List<AnotherEmployee> list1 = repo.findByDept(admin);
        list1.stream().forEach(System.out::println);

        System.out.println(" -- finding by salary greater than 3000 --");
        List<AnotherEmployee> list2 = repo.findBySalaryGreaterThan(3000);
        list2.stream().forEach(System.out::println);

//        System.out.println(" -- finding by dept=IT and salary less than 4000 --");
//        List<AnotherEmployee> list3 = repo.findByDeptAndSalaryLessThan("IT", 4000);
//        list3.stream().forEach(System.out::println);

        System.out.println(" -- finding all employees again --");
        Iterable<AnotherEmployee> all2 = repo.findAll();
        System.out.println(all2);
    }

    private List<Dept> createDepts(){
        return Arrays.asList(new Dept(1,"Admin"),
                new Dept(2,"IT"),
                new Dept(3,"Sale"),
                new Dept(4,"HR"));
    }

//    private List<AnotherEmployee> createEmployees() {
//        return Arrays.asList(new AnotherEmployee(1L,"Anand","IT",5000),
//                new AnotherEmployee(2L,"Abhinav","HR",2500),
//                new AnotherEmployee(3L,"santosh","accounts",3500),
//                new AnotherEmployee(4L,"Sophia","IT",4000),
//                new AnotherEmployee(5l,"Rose" ,"Sale",4000));
//    }
    private List<AnotherEmployee> createEmployees(){
        Dept admin = new Dept(1,"Admin");
        Dept it = new Dept(2,"IT");
        Dept sale = new Dept(3,"Sale");
        Dept hr = new Dept(4,"HR");

        return Arrays.asList(new AnotherEmployee(1L,"Abhinav",hr,5000),
                new AnotherEmployee(2L,"Santosh",sale,3500),
                new AnotherEmployee(3L,"anand",admin,7000),
                new AnotherEmployee(4L,"sophia",it,4000),
                new AnotherEmployee(5L,"Rose",sale,3500));



    }
}
