package com.softwarecafe.jpaPagingSorting.repository;

import com.softwarecafe.jpaPagingSorting.model.Employee6;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplQuerydslReposotory extends CrudRepository<Employee6,Long>  {
}
//public interface EmplQuerydslReposotory extends CrudRepository<Employee6,Long> , QuerydslPredicateExecutor<Employee6> {
//}
