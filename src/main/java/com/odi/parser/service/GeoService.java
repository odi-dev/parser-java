package com.odi.parser.service;

import com.odi.parser.model.kakao.AddressResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoService {
    private RestTemplate restTemplate = new RestTemplate();
    private String serviceKey = "d49bc62ec8fc59213ead3710de9557ce";

    public AddressResponse getAddress(String addressName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + serviceKey);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        return restTemplate.exchange("https://dapi.kakao.com/v2/local/search/address.json?query=" + addressName, HttpMethod.GET, entity, AddressResponse.class).getBody();
    }

}
