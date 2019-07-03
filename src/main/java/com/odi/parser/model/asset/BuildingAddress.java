package com.odi.parser.model.asset;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "building_address")
public class BuildingAddress extends AddressAbstractEntity {

    @Column(name = "building_id")
    private Long buildingId;

    @Builder
    public BuildingAddress(Long id, String addressName, String region1depthName, String region2depthName, String region3depthName, BigDecimal x, BigDecimal y, Long buildingId) {
        super(id, addressName, region1depthName, region2depthName, region3depthName, x, y);
        this.buildingId = buildingId;
    }
}
