package com.odi.parser.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildingAddressRepositoryTest {

    @Autowired
    BuildingAddressRepository buildingAddressRepository;

    @Test
    public void findByBuildingId() {
        System.out.println(buildingAddressRepository.findByBuildingId((long) 1356));
    }

}
