package com.softwarecafe.usingSpELGenericRepositiry;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TaskRepository<T extends Task> extends CrudRepository<T,Long> {
    @Query("SELECT t FROM #{#entityName} t WHERE t.name = ?1")
    public List<T> findTaskByName(String taskName);
}
