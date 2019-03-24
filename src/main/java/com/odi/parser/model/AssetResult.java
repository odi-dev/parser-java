package com.odi.parser.model;

import com.odi.parser.model.asset.Asset;
import lombok.Data;

@Data
public class AssetResult {

    private String name;
    private Asset asset;
}
