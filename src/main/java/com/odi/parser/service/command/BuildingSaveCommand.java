package com.odi.parser.service.command;

import com.odi.parser.model.asset.AssetNode;
import com.odi.parser.model.asset.Building;
import com.odi.parser.repository.BuildingRepository;
import com.odi.parser.service.AssetParserService;

import java.sql.Date;

public class BuildingSaveCommand implements AssetSaveCommand {

    private AssetParserService assetParserService;
    private BuildingRepository buildingRepository;

    public BuildingSaveCommand(AssetParserService assetParserService, BuildingRepository buildingRepository) {
        this.assetParserService = assetParserService;
        this.buildingRepository = buildingRepository;
    }

    @Override
    public void execute(AssetNode assetNode, Date registeredAt) {
        try {
            Building building = assetParserService.convertAssetNodeToBuilding(assetNode, registeredAt);
            if(buildingRepository.findByMemberIdAndDescriptionAndRegisteredAtAndRelation(building.getMemberId(), building.getDescription(), building.getRegisteredAt(), building.getRelationId()) == null)
                buildingRepository.save(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
