package com.softwarecafe.jpaProjections.service;

import com.softwarecafe.jpaProjections.model.Artisandpt;
import com.softwarecafe.jpaProjections.projectionIntrfaces.ArtisandptBeanInfo;
import com.softwarecafe.jpaProjections.repository.ArtisanOfBeanRepository;
import com.softwarecafe.jpaProjections.repository.ArtisandptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtisandptClient2 {

    @Autowired
    private ArtisanOfBeanRepository repo;

    public void run(){
        System.out.println("-- finding all employees --");
        Iterable<Artisandpt> all = repo.findAll();
        all.forEach(System.out::println);

        System.out.println("-- All EmployeeInfo --");
        List<ArtisandptBeanInfo> list = repo.findBy();

        System.out.println("-- display strings --");
        list.forEach(employeeInfo -> System.out.println(employeeInfo.getDisplayString()));

        System.out.println("-- detailed display strings --");
        list.forEach(employeeInfo -> {
            String str = employeeInfo.getDetailedString("Employee", "Department");
            System.out.println(str);
        });
    }
}
