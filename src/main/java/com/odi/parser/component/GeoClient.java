package com.odi.parser.component;

import com.odi.parser.model.asset.Land;
import com.odi.parser.model.asset.LandAddress;
import com.odi.parser.model.kakao.Address;
import com.odi.parser.model.kakao.AddressResponse;
import com.odi.parser.repository.LandAddressRepository;
import com.odi.parser.repository.LandRepository;
import com.odi.parser.service.AddressParserService;
import com.odi.parser.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeoClient {

    @Autowired
    GeoService geoService;

    @Autowired
    LandRepository landRepository;

    @Autowired
    LandAddressRepository landAddressRepository;

    @Autowired
    AddressParserService addressParserService;

    public void insertLandAddress() {
        Iterable<Land> lands = landRepository.findAll();
        for(Land land : lands) {
            String addressName = land.getAddressName();
            AddressResponse addressResponse = geoService.getAddress(addressName);

            if (!addressResponse.hasSingleAddress()) {
                addressName = invalidLandAddressNameToValidName(addressName);
                addressResponse = geoService.getAddress(addressName);
                // System.out.println(addressName);
                // System.out.println(address);
            }

            if(addressResponse.isValidAddress(addressName)) {
                Address address = addressResponse.getFirstAddress();
                Long landId = land.getId();
                LandAddress landAddress = addressParserService.convertAddressToLandAddress(address, landId);

                if(landAddressRepository.findByLandId(landId) == null)
                    landAddressRepository.save(landAddress);
            }

        }
    }

    private String invalidLandAddressNameToValidName(String addressName) {
       if(addressName.equals("울산광역시 북구 명촌동 0-0번지"))
           return "울산광역시 북구 명촌동";

       if(addressName.equals("충청북도 음성군 삼성면 34-9번지"))
           return "충북 음성군 삼성면 용성리 34-9번지";

       if(addressName.equals("전라북도 군산시 회현면 학당리 1268-7번지"))
           return "전라북도 군산시 회현면 학당리 1268-31번지";

       if(addressName.equals("충청북도 청주시 상당구 가덕면 산 5-1번지"))
           return "충청북도 청주시 상당구 가덕면 시동리 산 5-1번지";

       if(addressName.equals("전라남도 여수시 소라면 덕양리 1042-96번지"))
           return "전남 여수시 소라면 덕양리 1042-95번지";

       if(addressName.equals("전라남도 여수시 율촌면 취적리 184-1번지"))
           return "전남 여수시 율촌면 취적리 산 184-1번지";

       if(addressName.equals("충청북도 단양군 적성면 1013-1번지"))
           return "충북 단양군 적성면 상리 1013-1번지";

       if(addressName.equals("전라북도 순창군 풍산면 유정리 476번지"))
           return "전라북도 순창군 풍산면 유정리 476-1번지";

       if(addressName.equals("경기도 안성시 죽산면 당목리 산 58-4번지"))
           return "경기도 안성시 죽산면 당목리 산 58번지";

       if(addressName.equals("전라북도 진안군 동향면 산 186번지"))
           return "전북 진안군 동향면 능금리 산 186번지";

       if(addressName.equals("부산광역시 해운대구광역시 중동 1394-55번지"))
           return "부산광역시 해운대구 중동 1394-55번지";

       if(addressName.equals("부산광역시 해운대구광역시 반송동 726번지"))
           return "부산광역시 해운대구 반송동 726번지";

       if(addressName.equals("부산광역시 해운대구광역시 반송동 745-1번지"))
           return "부산광역시 해운대구 반송동 745-1번지";

       if(addressName.equals("부산광역시 해운대구광역시 반송동 745-8번지"))
           return "부산광역시 해운대구 반송동 745-8번지";

       if(addressName.equals("부산광역시 해운대구광역시 반송동 산 68-3번지"))
           return "부산광역시 해운대구 반송동 산 68-3번지";

       if(addressName.equals("부산광역시 해운대구광역시 반송동 산 68-5번지"))
           return "부산광역시 해운대구 반송동 산 68-5번지";

       if(addressName.equals("부산광역시 해운대구광역시 반송동 산 68-6번지"))
           return "부산광역시 해운대구 반송동 산 68-6번지";

       if(addressName.equals("부산광역시 해운대구광역시 석대동 156번지"))
           return "부산광역시 해운대구 석대동 156번지";

       if(addressName.equals("경상남도 김해시 생림면 313-1번지"))
           return "경상남도 김해시 생림면 사촌리 313-1번지";

       if(addressName.equals("경상남도 김해시 생림면 314-1번지"))
           return "경상남도 김해시 생림면 사촌리 314-1번지";

       if(addressName.equals("경상북도 영천시 고경면 오류리 19-13번지"))
           return "경상북도 영천시 고경면 오류리 산 19-13번지";

       if(addressName.equals("경상북도 상주시 모서면 호음리 615번지"))
           return "경상북도 상주시 모서면 호음리 615-1번지";

       return addressName;
    }

}
