package com.softwarecafe.jpaProjections.service;

import com.softwarecafe.jpaProjections.model.Artisandpt;
import com.softwarecafe.jpaProjections.model.Department;
import com.softwarecafe.jpaProjections.projectionIntrfaces.ArtisandptInfo;
import com.softwarecafe.jpaProjections.repository.ArtisandptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ArtisandptClient {

    @Autowired
    private ArtisandptRepository repo;

    public void run() {
//        List<Artisandpt> employees = createEmployees();
//        repo.saveAll(employees);

        System.out.println(" -- finding all Artisans --");
        Iterable<Artisandpt> all = repo.findAll();
        all.forEach(System.out::println);

//        System.out.println(" -- All EmployeeInfo --");
//        List<ArtisandptInfo> list = repo.findBy();
//        for (ArtisandptInfo ei : list) {
//            ArtisandptInfo.DeptInfo di = ei.getDepartment();
//            System.out.printf("Name: %s, Salary: %s, Dept: %s%n",
//                    ei.getName(), ei.getSalary(), di.getDeptName());
//        }
//
//        System.out.println(" -- EmployeeInfo with salary between 3000 and 4000 --");
//        list = repo.findBySalaryBetween(3000, 4000);
//        for (ArtisandptInfo ei : list) {
//            ArtisandptInfo.DeptInfo di = ei.getDepartment();
//            System.out.printf("Name: %s, Salary: %s, Dept: %s%n",
//                    ei.getName(), ei.getSalary(), di.getDeptName());
//        }
//
//        System.out.println(" -- EmployeeInfo with dept Location TX --");
//        list = repo.findByDepartmentLocation("TX");
//        for (ArtisandptInfo ei : list) {
//            ArtisandptInfo.DeptInfo di = ei.getDepartment();
//            System.out.printf("Name: %s, Salary: %s, Dept: %s%n",
//                    ei.getName(), ei.getSalary(), di.getDeptName());
//        }

        System.out.println("--All ArtisandeptInfo--");
        List<ArtisandptInfo> list = repo.findBy();
        System.out.println("--Display String--");
        list.forEach(artisandptInfo -> System.out.println(artisandptInfo.getDisplayString()));
        System.out.println("--Detailed display string--");
        list.forEach(artisandptInfo -> System.out.println(artisandptInfo.getDetailedString("Artisandpt","Department")));


    }

//    private List<Artisandpt> createEmployees() {
//        return Arrays.asList(
//                Artisandpt.of("Diana", Department.of("Admin", "NY"), 3000),
//                Artisandpt.of("Mike", Department.of("IT", "TX"), 35000),
//                Artisandpt.of("Rose", Department.of("Sales", "NC"), 4000),
//                Artisandpt.of("Sara", Department.of("Admin", "TX"), 3500),
//                Artisandpt.of("Joe", Department.of("IT", "TX"), 3000),
//                Artisandpt.of("Charlie", Department.of("IT", "NY"), 4500)
//        );
//    }
}
