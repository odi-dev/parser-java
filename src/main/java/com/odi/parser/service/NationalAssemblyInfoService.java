package com.odi.parser.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.odi.parser.model.nationalassembly.CurrStateResponse;
import com.odi.parser.model.nationalassembly.MemberDetailResponse;
import com.odi.parser.service.util.JsonUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NationalAssemblyInfoService {
    private RestTemplate restTemplate = new RestTemplate();
    private String serviceKey = "%2Fu2AU25IoxIFRV9%2FnJzYS%2FI7CyEQ8LR%2FPFSbvSSJjzIGD2OLDUmPfnTCvyy0t0wOAa7t7eaF8nVCD4u0QmkQWw%3D%3D";

    public List<CurrStateResponse> getMemberCurrStateList() throws URISyntaxException, IOException {
        List<CurrStateResponse> result = new ArrayList<>();

        ResponseEntity<String> responseEntity = requestMemberCurrStateList();
        JsonNode list = JsonUtil.toJsonNode(responseEntity.getBody()).get("response").get("body").get("items").get("item");
        for(JsonNode item : list) {
            CurrStateResponse currStateResponse = JsonUtil.toObject(item.toString(), CurrStateResponse.class);
            result.add(currStateResponse);
        }

        return result;
    }

    public MemberDetailResponse getMemberDetailInfo(int deptCd, int num) throws URISyntaxException, IOException {
        ResponseEntity<String> responseEntity = requestMemberDetailInfoList(deptCd, num);
        MemberDetailResponse result = JsonUtil.toObject(JsonUtil.toJsonNode(responseEntity.getBody()).get("response").get("body").get("item").toString(), MemberDetailResponse.class);

        return result;
    }

    private ResponseEntity<String> requestMemberCurrStateList() throws URISyntaxException {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("apis.data.go.kr").path("/9710000/NationalAssemblyInfoService/getMemberCurrStateList")
                .queryParam("serviceKey", serviceKey)
                .queryParam("numOfRows", 999)
                .build();

        return restTemplate.getForEntity(new URI(uriComponents.toUriString()), String.class);
    }

    private ResponseEntity<String> requestMemberDetailInfoList(int deptCd, int num) throws URISyntaxException {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("apis.data.go.kr").path("/9710000/NationalAssemblyInfoService/getMemberDetailInfoList")
                .queryParam("serviceKey", serviceKey)
                .queryParam("dept_cd", deptCd)
                .queryParam("num", num)
                .build();

        return restTemplate.getForEntity(new URI(uriComponents.toUriString()), String.class);
    }
    
}
