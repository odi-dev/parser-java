package com.odi.parser.model.asset;

import com.odi.parser.model.enums.AssetType;
import com.odi.parser.model.enums.RelationType;
import lombok.Data;

@Data
public class AssetNode {
    private AssetType assetType;
    private RelationType relationType;
    private String name;
    private String type;
    private Long lastPrice;
    private Long price;
    private String description;
    private String reason;

    public AssetNode(AssetType assetType, String name) {
        this.assetType = assetType;
        this.name = name;
    }

    public void setLastPrice(String lastPrice) {
        String value = lastPrice.replace(",","").replace("-", "");
        if(value.isEmpty()) {
            this.lastPrice = Long.valueOf(0);
        } else {
            this.lastPrice = Long.valueOf(value);
        }
    }

    public void setPrice(String price) {
        String value = price.replace(",","").replace("-", "");
        if(value.isEmpty()) {
            this.price = Long.valueOf(0);
        } else {
            this.price = Long.valueOf(value);
        }
    }
}
