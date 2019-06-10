package com.odi.parser.model.asset;

import com.odi.parser.model.Relation;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
@NoArgsConstructor
public class Land extends AssetAbstractEntity {

    @Builder
    private Land(Long id, Date registeredAt, Long memberId, Relation relation, String type, Long lastPrice, Long price, String description, String reason) {
        super(id, registeredAt, memberId, relation, type, lastPrice, price, description, reason);
    }

    public String getAddressName() {
        int lastIndexOf = getDescription().lastIndexOf("번지");
        String addressName = getDescription().substring(0, lastIndexOf+2);
        return addressName.replace("[소재지 오기정정]", "").trim();
    }
}
