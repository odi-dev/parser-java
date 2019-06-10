package com.odi.parser.model.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class AddressResponse {

    private AddressMeta meta;
    private List<AddressDocument> documents;

}
