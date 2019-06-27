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
@Table(name = "land_address")
public class LandAddress extends AddressAbstractEntity {

    @Column(name = "land_id")
    private Long landId;

    @Builder
    public LandAddress(Long id, String addressName, String region1depthName, String region2depthName, String region3depthName, BigDecimal x, BigDecimal y, Long landId) {
        super(id, addressName, region1depthName, region2depthName, region3depthName, x, y);
        this.landId = landId;
    }
}
