package com.odi.parser.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class NationalAssemblyInfoService {
    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://apis.data.go.kr/9710000/NationalAssemblyInfoService/getMemberDetailInfoList";

    public ResponseEntity<String> getMemberCurrStateList() throws URISyntaxException {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("apis.data.go.kr").path("/9710000/NationalAssemblyInfoService/getMemberCurrStateList")
                .queryParam("serviceKey", "%2Fu2AU25IoxIFRV9%2FnJzYS%2FI7CyEQ8LR%2FPFSbvSSJjzIGD2OLDUmPfnTCvyy0t0wOAa7t7eaF8nVCD4u0QmkQWw%3D%3D")
                .queryParam("numOfRows", 999)
                .queryParam("pageNo", 1)
                .build();

        return restTemplate.getForEntity(new URI(uriComponents.toUriString()), String.class);
    }

    public ResponseEntity<String> getMemberDetailInfoList(int deptCd, int num) throws URISyntaxException {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("apis.data.go.kr").path("/9710000/NationalAssemblyInfoService/getMemberDetailInfoList")
                .queryParam("serviceKey", "%2Fu2AU25IoxIFRV9%2FnJzYS%2FI7CyEQ8LR%2FPFSbvSSJjzIGD2OLDUmPfnTCvyy0t0wOAa7t7eaF8nVCD4u0QmkQWw%3D%3D")
                .queryParam("numOfRows", 999)
                .queryParam("pageNo", 1)
                .queryParam("dept_cd", deptCd)
                .queryParam("num", num)
                .build();

        return restTemplate.getForEntity(new URI(uriComponents.toUriString()), String.class);
    }
    
}
