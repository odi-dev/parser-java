package com.odi.parser.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationRepositoryTest {

    @Autowired
    RelationRepository relationRepository;

    @Test
    public void findAll() {
        System.out.println(relationRepository.findAll());
    }

    @Test
    public void findByType() {
        System.out.println(relationRepository.findByType("배우자"));
    }

}