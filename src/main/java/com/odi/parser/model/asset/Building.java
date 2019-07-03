package com.odi.parser.model.asset;

import com.odi.parser.model.Relation;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
@NoArgsConstructor
public class Building extends AssetAbstractEntity {

    @Builder
    private Building(Long id, Date registeredAt, Long memberId, Relation relation, String type, Long lastPrice, Long price, String description, String reason) {
        super(id, registeredAt, memberId, relation, type, lastPrice, price, description, reason);
    }

    public String getAddressName() {
        String addressName = getDescription();

        // '건물', '대지' 이하 제거
        int indexOf = addressName.indexOf("건물");
        if(indexOf > 0) {
            addressName = getDescription().substring(0, indexOf);
            int nextIndexOf = addressName.indexOf("대지");

            if(nextIndexOf > 0) {
                addressName = addressName.substring(0, nextIndexOf);
            }
        }
        addressName = addressName.replace("[소재지 오기정정]", "").trim();

        // 도/시 기준으로 주소 파싱
        String[] split = addressName.split(" ");
        char lastChar = split[0].charAt(split[0].length() - 1);
        if(lastChar == '도') {
            if(split.length >= 4) {
                // 마지막 행 검사
                if(isValidAddress(split[3])) {
                    addressName = split[0] + " " + split[1] + " " + split[2] + " " + split[3];
                } else {
                    addressName = split[0] + " " + split[1] + " " + split[2];
                }
            }
        } else if(lastChar == '시') {
            addressName = split[0] + " " + split[1] + " " + split[2];
        }

        return addressName;
    }

    private boolean isValidAddress(String string) {
        if(string.contains("아파트") || string.contains("단지") || string.contains("오피스텔") || string.contains("상가") || string.contains("("))
            return false;

        char lastChar = string.charAt(string.length() - 1);
        if(lastChar == '동' || lastChar == '읍' || lastChar == '면' || lastChar == '가')
            return true;

        return false;
    }
}
