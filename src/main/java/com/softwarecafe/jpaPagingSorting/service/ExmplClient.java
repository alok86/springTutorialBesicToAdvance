package com.softwarecafe.jpaPagingSorting.service;

import com.softwarecafe.jpaPagingSorting.model.Employee6;
import com.softwarecafe.jpaPagingSorting.repository.EmplPaginAndSorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ExmplClient {
    @Autowired
    private EmplPaginAndSorting repo;
    public void run(){
        System.out.println(" -- finding all employees sorted by names --");
        Iterable<Employee6> all = repo.findAll(Sort.by("name"));
        all.forEach(System.out::println);

        System.out.println(" -- paginate employees sorted by salaries --");
        Pageable pageable = PageRequest.of(3, 10,
                Sort.by("salary").descending());

        while(true){
            Page<Employee6> page = repo.findAll(pageable);
            System.out.println("Page no: "+page.getNumber());
            page.getContent().forEach(System.out::println);
            if(!page.hasNext()){
                break;
            }
            pageable = page.nextPageable();
        }
    }
}
