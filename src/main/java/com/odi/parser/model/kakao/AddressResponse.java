package com.odi.parser.model.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class AddressResponse {

    private AddressMeta meta;
    private List<AddressDocument> documents;

    public boolean hasSingleAddress() {
        return meta.getTotal_count() == 1;
    }

    public boolean isValidLandAddress(String addressName) {
        if(addressName.equals("0"))
            return false;

        if(meta.getTotal_count() > 0)
            return true;

        throw new RuntimeException("Invalid Address");
    }

    public boolean isValidBuildingAddress(String addressName) {
        if(addressName.equals("일본") || addressName.equals("미국"))
            return true;

        if(meta.getTotal_count() > 0)
            return true;

        throw new RuntimeException("Invalid Address");
    }

    public Address getFirstAddress() {
        return documents.get(0).getAddress();
    }

}
