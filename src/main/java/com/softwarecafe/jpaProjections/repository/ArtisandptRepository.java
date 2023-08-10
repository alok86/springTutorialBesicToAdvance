package com.softwarecafe.jpaProjections.repository;

import com.softwarecafe.jpaProjections.model.Artisandpt;
import com.softwarecafe.jpaProjections.projectionIntrfaces.ArtisandptBeanInfo;
import com.softwarecafe.jpaProjections.projectionIntrfaces.ArtisandptInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArtisandptRepository extends CrudRepository<Artisandpt,Integer> {
    List<ArtisandptInfo> findBy();


    List<ArtisandptInfo> findBySalaryBetween(int salaryMin , int salaryMax);
    List<ArtisandptInfo> findByDepartmentLocation(String location);
}
