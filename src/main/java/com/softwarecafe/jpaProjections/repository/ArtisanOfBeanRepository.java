package com.softwarecafe.jpaProjections.repository;

import com.softwarecafe.jpaProjections.model.Artisandpt;
import com.softwarecafe.jpaProjections.projectionIntrfaces.ArtisandptBeanInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtisanOfBeanRepository extends CrudRepository<Artisandpt, Integer> {
    List<ArtisandptBeanInfo> findBy();
}
