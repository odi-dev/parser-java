package com.odi.parser.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NationalAssemblyInfoServiceTest {

    @Autowired
    NationalAssemblyInfoService nationalAssemblyInfoService;

    @Test
    public void getMemberCurrStateList() throws Exception {
        ResponseEntity<String> response = nationalAssemblyInfoService.getMemberCurrStateList();
        System.out.println(response);
    }

    @Test
    public void getMemberDetailInfoList() throws Exception {
        ResponseEntity<String> response = nationalAssemblyInfoService.getMemberDetailInfoList(9770276, 153);
        System.out.println(response);
    }

}
