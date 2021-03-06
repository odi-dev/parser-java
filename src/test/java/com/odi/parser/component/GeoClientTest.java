package com.odi.parser.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeoClientTest {

    @Autowired
    GeoClient geoClient;

    @Test
    public void insertLandAddress() {
        geoClient.insertLandAddress();
    }

    @Test
    public void insertBuildingAddress() {
        geoClient.insertBuildingAddress();
    }

}
