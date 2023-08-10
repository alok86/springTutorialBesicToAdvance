package com.softwarecafe.jpaProjections.repository;

import com.softwarecafe.jpaProjections.beans.ArtisanInfo;
import com.softwarecafe.jpaProjections.model.Artisan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// this Repository belongs to bean ArtisanInfo
@Repository
public interface ArtisanClassBasedRepository extends CrudRepository<Artisan,Long> {

    List<ArtisanInfo> findBy();
    List<ArtisanInfo> findByDept(String dept);
}
