package com.softwarecafe.jpaProjections.beans;

/**
 * Projection for {@link com.softwarecafe.jpaProjections.model.Artisan}
 */
public interface ArtisanProjectionInfo {
    String getName();

    String getDept();

    Integer getSalary();
}