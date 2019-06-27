package com.odi.parser.service;

import com.odi.parser.model.asset.LandAddress;
import com.odi.parser.model.kakao.Address;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AddressParserService {

    public LandAddress convertAddressToLandAddress(Address address, Long landId) {
        return LandAddress.builder()
                .landId(landId)
                .addressName(address.getAddress_name())
                .region1depthName(address.getRegion_1depth_name())
                .region2depthName(address.getRegion_2depth_name())
                .region3depthName(address.getRegion_3depth_name())
                .x(new BigDecimal(address.getX()))
                .y(new BigDecimal(address.getY()))
                .build();
    }
}
