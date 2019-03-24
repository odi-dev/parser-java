package com.odi.parser.model.asset;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.odi.parser.model.enums.RelationType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Land {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer memberId;
    private String type;

    @JsonProperty("last_price")
    private Integer lastPrice;
    private Integer price;
    private Date registeredAt;

    @Column(name = "relation")
    private Integer relationId;
    private String description;
    private String reason;

    @Transient
    private RelationType relation;

    @JsonProperty("price_increase")
    @Transient
    private Integer priceIncrease;

    @JsonProperty("price_decrease")
    @Transient
    private Integer priceDecrease;

    public void setLastPrice(String lastPrice) {
        this.lastPrice = Integer.valueOf(lastPrice.replace(",",""));
    }

    public void setPrice(String price) {
        this.price = Integer.valueOf(price.replace(",",""));
    }

    public void setPriceIncrease(String priceIncrease) {
        this.priceIncrease = Integer.valueOf(priceIncrease.replace(",",""));
    }

    public void setPriceDecrease(String priceDecrease) {
        this.priceDecrease = Integer.valueOf(priceDecrease.replace(",",""));
    }
}
