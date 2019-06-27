package com.odi.parser.repository;

import com.odi.parser.model.asset.LandAddress;
import org.springframework.data.repository.CrudRepository;

public interface LandAddressRepository extends CrudRepository<LandAddress, Long> {

    LandAddress findByLandId(Long landId);
}
