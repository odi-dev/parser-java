package com.odi.parser.component;

import com.odi.parser.model.asset.Building;
import com.odi.parser.model.asset.BuildingAddress;
import com.odi.parser.model.asset.Land;
import com.odi.parser.model.asset.LandAddress;
import com.odi.parser.model.kakao.Address;
import com.odi.parser.model.kakao.AddressResponse;
import com.odi.parser.repository.BuildingAddressRepository;
import com.odi.parser.repository.BuildingRepository;
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
    BuildingRepository buildingRepository;

    @Autowired
    LandAddressRepository landAddressRepository;

    @Autowired
    BuildingAddressRepository buildingAddressRepository;

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

            if(addressResponse.isValidLandAddress(addressName)) {
                Address address = addressResponse.getFirstAddress();
                Long landId = land.getId();
                LandAddress landAddress = addressParserService.convertAddressToLandAddress(address, landId);

                if(landAddressRepository.findByLandId(landId) == null)
                    landAddressRepository.save(landAddress);
            }

        }
    }

    public void insertBuildingAddress() {
        Iterable<Building> buildings = buildingRepository.findAll();
        for(Building building : buildings) {
            String addressName = building.getAddressName();
            AddressResponse addressResponse = geoService.getAddress(addressName);

            if (!addressResponse.hasSingleAddress()) {
                addressName = invalidBuildingAddressNameToValidName(addressName);
                addressResponse = geoService.getAddress(addressName);
                // System.out.println(addressName);
                // System.out.println(addressResponse);
            }

            if(addressResponse.isValidBuildingAddress(addressName)) {
                Address address;
                if(addressName.equals("일본") || addressName.equals("미국"))
                    address = new Address(addressName, addressName);
                else
                    address = addressResponse.getFirstAddress();

                Long buildingId = building.getId();
                BuildingAddress buildingAddress = addressParserService.convertAddressToBuildingAddress(address, buildingId);

                if(buildingAddressRepository.findByBuildingId(buildingId) == null)
                    buildingAddressRepository.save(buildingAddress);
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

    private String invalidBuildingAddressNameToValidName(String addressName) {
        if(addressName.equals("서울특별시 동작구 수석빌딩"))
            return "서울 동작구 상도로 30";

        if(addressName.equals("서울특별시서초구방배동 롯데캐슬아르떼"))
            return "서울 서초구 방배천로18길 11";

        if(addressName.equals("경기도용인시수지구풍덕천동 수지현대아파트"))
            return "경기 용인시 수지구 수지로342번길 16";

        if(addressName.equals("경기도용인시수지구죽전동 동부센트레빌아파트"))
            return "경기 용인시 수지구 대지로 137";

        if(addressName.equals("세종특별자치시 도담동 도담센트럴프라자"))
            return "세종특별자치시 한누리대로 583 도담센트럴프라자 702호";

        if(addressName.equals("세종특별자치시 도담동 라온프라이빗시티1"))
            return "세종특별자치시 도담동 665";

        if(addressName.equals("경기도 파주시 문발동 제별관동"))
            return "경기도 파주시 문발동";

        if(addressName.equals("경기도 파주시 문발동 제은하관동"))
            return "경기도 파주시 문발동";

        if(addressName.equals("세종특별자치시 대평동 3-1생활권"))
            return "세종특별자치시 대평3길 18";

        if(addressName.equals("서울특별시 양천구 목6동"))
            return "서울특별시 양천구 목동";

        if(addressName.equals("동경 미나토구 아카사카"))
            return "일본";

        if(addressName.equals("Yearling Terrace Rockville"))
            return "미국";

        if(addressName.equals("Bellezza Hakubaicho, Kamiyagawa-cho"))
            return "일본";

        if(addressName.equals("Brookdale drive, Santa Clara, CA"))
            return "미국";

        if(addressName.equals("Overland Park Drive Greensboro NC"))
            return "미국";

        return addressName;
    }

}
