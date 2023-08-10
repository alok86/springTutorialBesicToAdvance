package com.softwarecafe.jpaPagingSorting.service;

import com.softwarecafe.jpaPagingSorting.model.Employee6;
import com.softwarecafe.jpaPagingSorting.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExampleClient {
    @Autowired
    private EmpRepository repo;

    public void run() {
        // only need to run first time for later exampel it is no need to run again and again
       /* List<Employee6> employees = createEmployees();
        repo.saveAll(employees);*/

        System.out.println(" -- finding all employees --");
        Iterable<Employee6> all = repo.findAll();
        all.forEach(System.out::println);

       // System.out.println(" -- finding by dept Sales sort by 'salary' and 'name' --");
//        List<Employee6> list = repo.findByDept("Sales", Sort.by("salary", "name").ascending());
        //Requesting data as per page request
        // List<Employee6> list = repo.findByDept("Sales", PageRequest.of(0,3));
        //Requesting data as per page and sort by any column such as salary
        //List<Employee6> list = repo.findByDept("Sales",PageRequest.of(4,3,Sort.by("salary")));
        //list.forEach(System.out::println);

       /* System.out.println("Pagainating where dept is sales using slice \n Slice is a sized chunk of data with an indication of whether there is more data available.");

        Slice<Employee6> slice = null;
        Pageable pageable = PageRequest.of(0,3,Sort.by("salary"));
       do{
            slice = repo.findByDept("Sales",pageable);
            int number = slice.getNumber();
            int numberOfElement = slice.getNumberOfElements();
            int size = slice.getSize();
            System.out.printf("Slice info = Page number %s, number of Element %s , size %s%n",number,numberOfElement,size);
            List<Employee6> list = slice.getContent();
            list.forEach(System.out::println);

        } while (slice.hasNext());*/

        /*
        * As opposed to Slice (last tutorial), Page knows about the total number
        *  of elements and pages available. It does so by triggering a count query
        *  to calculate the overall number. This might be expensive for large number
        *  of dataset.

        Page is a subclass of Slice.
        * */
        System.out.println(" -- paginating where dept is Sales --");
        Page<Employee6> page = null;
        Pageable pageable = PageRequest.of(0, 3, Sort.by("salary"));
        while (true) {
            page = repo.findByDept("Sales", pageable);
            int number = page.getNumber();
            int numberOfElements = page.getNumberOfElements();
            int size = page.getSize();
            long totalElements = page.getTotalElements();
            int totalPages = page.getTotalPages();
            System.out.printf("page info - page number %s, numberOfElements: %s, size: %s, "
                            + "totalElements: %s, totalPages: %s%n",
                    number, numberOfElements, size, totalElements, totalPages);
            List<Employee6> employeeList = page.getContent();
            employeeList.forEach(System.out::println);
            if (!page.hasNext()) {
                break;
            }
            pageable = page.nextPageable();
        }

    }

    private List<Employee6> createEmployees() {
        return Arrays.asList(
                Employee6.create("Diana", "Sales", 2000),
                Employee6.create("Mike", "Sales", 1000),
                Employee6.create("Rose", "IT", 4000),
                Employee6.create("Sara", "Sales", 3000),
                Employee6.create("Andy", "Sales", 3000),
                Employee6.create("Charlie", "IT", 2500)
        );
    }

}
