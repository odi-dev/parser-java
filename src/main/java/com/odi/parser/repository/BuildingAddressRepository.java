package com.odi.parser.repository;

import com.odi.parser.model.asset.BuildingAddress;
import org.springframework.data.repository.CrudRepository;

public interface BuildingAddressRepository extends CrudRepository<BuildingAddress, Long> {

    BuildingAddress findByBuildingId(Long buildingId);
}
