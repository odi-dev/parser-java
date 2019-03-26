package com.odi.parser.repository;

import com.odi.parser.model.asset.Building;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface BuildingRepository extends CrudRepository<Building, Long> {

    @Query(value = "select * from building where description = :description and registered_at = :registered_at", nativeQuery = true)
    Building findByDescriptionAndRegisteredAt(@Param("description") String description, @Param("registered_at") Date registeredAt);
}
