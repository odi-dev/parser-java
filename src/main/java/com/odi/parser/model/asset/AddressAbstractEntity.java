package com.odi.parser.model.asset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressAbstractEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address_name")
    private String addressName;
    @Column(name = "region_1depth_name")
    private String region1depthName;
    @Column(name = "region_2depth_name")
    private String region2depthName;
    @Column(name = "region_3depth_name")
    private String region3depthName;
    private BigDecimal x;
    private BigDecimal y;

}
