package com.softwarecafe.springDataJpaEnablingTransactions.service;

import com.softwarecafe.springDataJpaEnablingTransactions.repository.WorkerRepositoryModifyQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientOfModifyQuery {
    @Autowired
    private WorkerRepositoryModifyQuery repo;
    public void run(){
        System.out.println("-- all employees --");
        repo.findAll().forEach(System.out::println);

        System.out.println(" -- increasing salaries by 20% for IT dept --");
        int updateCount = repo.increaseSalaries( 20);
        System.out.println("Update count: " + updateCount);

        System.out.println("-- all employees after update--");
        repo.findAll().forEach(System.out::println);
    }
}
