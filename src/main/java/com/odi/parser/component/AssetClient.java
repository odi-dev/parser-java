package com.odi.parser.component;

import com.odi.parser.model.asset.AssetNode;
import com.odi.parser.model.asset.Building;
import com.odi.parser.model.asset.Land;
import com.odi.parser.repository.BuildingRepository;
import com.odi.parser.repository.LandRepository;
import com.odi.parser.service.AssetParserService;
import com.odi.parser.service.AssetReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Component
public class AssetClient {

    @Autowired
    AssetReaderService assetReaderService;

    @Autowired
    AssetParserService assetParserService;

    @Autowired
    LandRepository landRepository;

    @Autowired
    BuildingRepository buildingRepository;

    public void insertAssets() throws IOException {
        List<AssetNode> assetNodes = assetReaderService.readAssets();
        Date registeredAt = Date.valueOf("2018-03-29");

        for(AssetNode assetNode : assetNodes) {
            switch (assetNode.getAssetType()) {
                case LAND:
                    Land land = assetParserService.convertAssetNodeToLand(assetNode, registeredAt);

                    if(landRepository.findByDescriptionAndRegisteredAt(land.getDescription(), land.getRegisteredAt()) == null)
                        landRepository.save(land);
                    break;
                case BUILDING:
                    Building building = assetParserService.convertAssetNodeToBuilding(assetNode, registeredAt);

                    if(buildingRepository.findByDescriptionAndRegisteredAt(building.getDescription(), building.getRegisteredAt()) == null)
                        buildingRepository.save(building);
                    break;
            }
        }
    }
}
