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
}
