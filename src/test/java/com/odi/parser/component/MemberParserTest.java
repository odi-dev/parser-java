package com.odi.parser.component;

import com.odi.parser.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberParserTest {

    @Autowired
    MemberParser memberParser;

    @Test
    public void parseMembers() throws Exception {
        List<Member> members = memberParser.parseMembers();
        for (Member member : members)
            System.out.println(member);
    }

}
