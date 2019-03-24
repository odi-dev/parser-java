package com.odi.parser.model.asset;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Land {

    private Integer id;
    private Integer memberId;
    private String type;

    @JsonProperty("last_price")
    private Integer lastPrice;
    private Integer price;
    private Date registeredAt;
    private Integer relationId;
    private String description;
    private String reason;

    private String relation;

    @JsonProperty("price_increase")
    private Integer priceIncrease;

    @JsonProperty("price_decrease")
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
