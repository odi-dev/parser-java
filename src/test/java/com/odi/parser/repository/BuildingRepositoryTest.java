package com.odi.parser.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildingRepositoryTest {

    @Autowired
    BuildingRepository buildingRepository;

    @Test
    public void findAll() throws Exception {
        System.out.println(buildingRepository.findAll());
    }

    @Test
    public void findByMemberIdAndDescriptionAndRegisteredAt() throws Exception {
        Long memberId = Long.valueOf(245);
        String description = "서울특별시 마포구 상수동 신구강변연가아파트 건물 152.30m²";
        Date registeredAt = Date.valueOf("2018-03-29");
        System.out.println(buildingRepository.findByMemberIdAndDescriptionAndRegisteredAt(memberId, description, registeredAt));
    }

}