package com.odi.parser.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void findAll() {
        System.out.println(memberRepository.findAll());
    }

    @Test
    public void findByIdCode() {
        System.out.println(memberRepository.findByIdCode(153));
    }

    @Test
    public void findByName() {
        System.out.println(memberRepository.findByName("문희상"));
    }

    @Test
    public void findByNameAndZh() {
        System.out.println(memberRepository.findByNameAndZh("김성태", "金聖泰"));
    }

}
