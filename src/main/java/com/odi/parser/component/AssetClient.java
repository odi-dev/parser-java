package com.odi.parser.component;

import com.odi.parser.model.asset.AssetNode;
import com.odi.parser.repository.BuildingRepository;
import com.odi.parser.repository.LandRepository;
import com.odi.parser.service.AssetParserService;
import com.odi.parser.service.AssetReaderService;
import com.odi.parser.service.command.BuildingSaveCommand;
import com.odi.parser.service.command.LandSaveCommand;
import com.odi.parser.service.command.SaveCommandExecutor;
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
        SaveCommandExecutor saveCommandExecutor = new SaveCommandExecutor();

        for(AssetNode assetNode : assetNodes) {
            switch (assetNode.getAssetType()) {
                case LAND:
                    LandSaveCommand landSaveCommand = new LandSaveCommand(assetParserService, landRepository);
                    saveCommandExecutor.executeCommand(landSaveCommand, assetNode, registeredAt);
                    break;
                case BUILDING:
                    BuildingSaveCommand buildingSaveCommand = new BuildingSaveCommand(assetParserService, buildingRepository);
                    saveCommandExecutor.executeCommand(buildingSaveCommand, assetNode, registeredAt);
                    break;
            }
        }
    }
}
