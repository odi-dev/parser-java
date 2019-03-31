package com.odi.parser.service;

import com.odi.parser.model.nationalassembly.CurrStateResponse;
import com.odi.parser.model.nationalassembly.MemberDetailResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NationalAssemblyInfoServiceTest {

    @Autowired
    NationalAssemblyInfoService nationalAssemblyInfoService;

    @Test
    public void getMemberCurrStateList() throws Exception {
        List<CurrStateResponse> memberCurrStateList = nationalAssemblyInfoService.getMemberCurrStateList();
        System.out.println(memberCurrStateList);
    }

    @Test
    public void getMemberDetailInfo() throws Exception {
        MemberDetailResponse memberDetailInfo = nationalAssemblyInfoService.getMemberDetailInfo(9770276, 153);
        System.out.println(memberDetailInfo);
    }

}
