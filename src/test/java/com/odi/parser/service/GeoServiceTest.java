package com.odi.parser.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeoServiceTest {

    @Autowired
    GeoService geoService;

    @Test
    public void getAddress() throws Exception {
        String addressName = "부산광역시 해운대구 중동 1394-55번지";
        System.out.println(geoService.getAddress(addressName));
    }

}
