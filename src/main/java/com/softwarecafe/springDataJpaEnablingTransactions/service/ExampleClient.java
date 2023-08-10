package com.softwarecafe.springDataJpaEnablingTransactions.service;

import com.softwarecafe.springDataJpaEnablingTransactions.model.Worker;
import com.softwarecafe.springDataJpaEnablingTransactions.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExampleClient {
    @Autowired
    private WorkerRepository repo;

    public void findWorkers() {
        System.out.println(" -- finding all Workers --");
        repo.findAll().forEach(System.out::println);
    }

    @Transactional
    public void saveWorker() {
        repo.save(Worker.create("Mike", "Sale", 1000));
        repo.save(Worker.create("Diana", "Admin", 3000));
        repo.save(Worker.create("Tom", "IT", 3200));
    }
}
