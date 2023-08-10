package com.softwarecafe.jpaProjections.service;

import com.softwarecafe.jpaProjections.beans.ArtisanInfo;
import com.softwarecafe.jpaProjections.model.Artisan;
import com.softwarecafe.jpaProjections.repository.ArtisanClassBasedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtisanClassBasedClient {
    @Autowired
    private ArtisanClassBasedRepository repo;

    public void run(){

        System.out.println("--finding all Artisan--");
        Iterable<Artisan> artisans = repo.findAll();
        artisans.forEach(System.out::println);

        System.out.println("--finding all Artisan info--");
        List<ArtisanInfo> list = repo.findBy();

        list.forEach(artisan -> System.out.printf("Name: %s , Salary : %s%n", artisan.getName() , artisan.getSalary()) );

        System.out.println("--finding all Artisan info by IT dept--");
         list = repo.findByDept("IT");
        list.forEach(artisan -> System.out.printf("Name: %s , Salary : %s%n", artisan.getName() , artisan.getSalary()) );

    }
}
