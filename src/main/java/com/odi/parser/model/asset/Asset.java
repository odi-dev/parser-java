package com.odi.parser.model.asset;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Asset {

    @JsonProperty("land")
    private List<Land> lands;

    @JsonProperty("building")
    private List<Building> buildings;

}
