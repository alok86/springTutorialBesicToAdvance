package com.softwarecafe.jpaProjections.service;

import com.softwarecafe.jpaProjections.beans.ContactInfo;
import com.softwarecafe.jpaProjections.beans.SalaryInfo;
import com.softwarecafe.jpaProjections.model.Staff;
import com.softwarecafe.jpaProjections.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository repo;

    public void run() {


        System.out.println(" -- finding all staff --");
        Iterable<Staff> all = repo.findAll();
        all.forEach(System.out::println);

        System.out.println(" -- finding SalaryInfo for IT dept --");
        List<SalaryInfo> list = repo.findByDept("IT", SalaryInfo.class);
        list.forEach(System.out::println);

        System.out.println(" -- finding ContactInfo for IT dept --");
        List<ContactInfo> list2 = repo.findByDept("IT", ContactInfo.class);
        list2.forEach(System.out::println);
    }
}
