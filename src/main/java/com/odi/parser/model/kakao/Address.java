package com.odi.parser.model.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties
public class Address {

    private String address_name;
    private String region_1depth_name;
    private String region_2depth_name;
    private String region_3depth_name;
    private String region_3depth_h_name;
    private String h_code;
    private String b_code;
    private String main_address_no;
    private String sub_address_no;
    private String x;
    private String y;

    public Address(String address_name, String region_1depth_name) {
        this.address_name = address_name;
        this.region_1depth_name = region_1depth_name;
    }
}
