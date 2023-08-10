package com.softwarecafe.jpaProjections.repository;

import com.softwarecafe.jpaProjections.model.Artisan;
import com.softwarecafe.jpaProjections.projectionIntrfaces.ArtisanSalary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
    public List<ArtisanSalary> findBy();
    public List<ArtisanSalary> findByDept(String dept);
}