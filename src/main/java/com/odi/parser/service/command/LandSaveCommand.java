package com.odi.parser.service.command;

import com.odi.parser.model.asset.AssetNode;
import com.odi.parser.model.asset.Land;
import com.odi.parser.repository.LandRepository;
import com.odi.parser.service.AssetParserService;

import java.sql.Date;

public class LandSaveCommand implements AssetSaveCommand {

    private AssetParserService assetParserService;
    private LandRepository landRepository;

    public LandSaveCommand(AssetParserService assetParserService, LandRepository landRepository) {
        this.assetParserService = assetParserService;
        this.landRepository = landRepository;
    }

    @Override
    public void execute(AssetNode assetNode, Date registeredAt) {
        try {
            Land land = assetParserService.convertAssetNodeToLand(assetNode, registeredAt);
            if(landRepository.findByMemberIdAndDescriptionAndRegisteredAtAndRelation(land.getMemberId(), land.getDescription(), land.getRegisteredAt(), land.getRelationId()) == null)
                landRepository.save(land);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
