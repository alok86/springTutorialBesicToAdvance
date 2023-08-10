package com.softwarecafe.springDataJpaEnablingTransactions.repository;

import com.softwarecafe.springDataJpaEnablingTransactions.model.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
    @Transactional(timeout = 10)
    @Override
    <S extends Worker> S save(S s);
}