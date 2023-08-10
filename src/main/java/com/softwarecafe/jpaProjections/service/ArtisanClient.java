package com.softwarecafe.jpaProjections.service;

import com.softwarecafe.jpaProjections.model.Artisan;
import com.softwarecafe.jpaProjections.projectionIntrfaces.ArtisanSalary;
import com.softwarecafe.jpaProjections.repository.ArtisanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtisanClient {

    @Autowired
    private ArtisanRepository repo;

    public void run() {


        System.out.println(" -- finding all employees --");
        Iterable<Artisan> all = repo.findAll();
        all.forEach(System.out::println);

        System.out.println(" -- finding all EmployeeSalary --");
        List<ArtisanSalary> list = repo.findBy();
        for (ArtisanSalary es : list) {
            System.out.printf("Name: %s, Department: %s, Salary: %s%n", es.getName(), es.getDept() ,es.getSalary());
        }

        System.out.println(" -- finding the EmployeeSalary in IT dept --");
        list = repo.findByDept("IT");
        for (ArtisanSalary es : list) {
            System.out.printf("Name: %s, Department: %s, Salary: %s%n", es.getName(), es.getDept() ,es.getSalary());
        }
    }

}
