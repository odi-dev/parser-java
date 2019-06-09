package com.odi.parser.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LandRepositoryTest {

    @Autowired
    LandRepository landRepository;

    @Test
    public void findAll() throws Exception {
        System.out.println(landRepository.findAll());
    }

    @Test
    public void findByMemberIdAndDescriptionAndRegisteredAt() throws Exception {
        Long memberId = Long.valueOf(245);
        String description = "경상북도 포항시 북구 장성동 산 232번지 64,790.00m²";
        Date registeredAt = Date.valueOf("2018-03-29");
        System.out.println(landRepository.findByMemberIdAndDescriptionAndRegisteredAt(memberId, description, registeredAt));
        Long relationId = Long.valueOf(2);
        System.out.println(landRepository.findByMemberIdAndDescriptionAndRegisteredAtAndRelation(memberId, description, registeredAt, relationId));
    }

}
