package com.odi.parser.model.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class AddressDocument {

    private String address_name;
    private String address_type;
    private String x;
    private String y;
    private Address address;


}
