package com.softwarecafe.springDataJpaStarter;

import org.springframework.data.repository.CrudRepository;

public interface DeptRepository extends CrudRepository<Dept,Integer> {
    Dept findByName(String name);
}
