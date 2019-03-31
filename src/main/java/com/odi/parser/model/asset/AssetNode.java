package com.odi.parser.model.asset;

import com.odi.parser.model.Relation;
import com.odi.parser.model.enums.AssetType;
import com.odi.parser.model.enums.RelationType;
import lombok.Data;

import java.sql.Date;

@Data
public class AssetNode {
    private AssetType assetType;
    private RelationType relationType;
    private String name;
    private String type;
    private Integer lastPrice;
    private Integer price;
    private String description;
    private String reason;

    public AssetNode(AssetType assetType, String name) {
        this.assetType = assetType;
        this.name = name;
    }

    public void setLastPrice(String lastPrice) {
        String value = lastPrice.replace(",","").replace("-", "");
        if(value.isEmpty()) {
            this.lastPrice = 0;
        } else {
            this.lastPrice = Integer.valueOf(value);
        }
    }

    public void setPrice(String price) {
        String value = price.replace(",","").replace("-", "");
        if(value.isEmpty()) {
            this.price = 0;
        } else {
            this.price = Integer.valueOf(value);
        }
    }
}
