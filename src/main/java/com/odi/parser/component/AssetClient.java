package com.odi.parser.component;

import com.odi.parser.model.asset.AssetNode;
import com.odi.parser.repository.BuildingRepository;
import com.odi.parser.repository.LandRepository;
import com.odi.parser.repository.VehicleRepository;
import com.odi.parser.service.AssetParserService;
import com.odi.parser.service.AssetReaderService;
import com.odi.parser.service.command.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
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

    @Autowired
    VehicleRepository vehicleRepository;

    public final static String FOLDER_PATH = "csv/";
    public final static String NOTICE_DATE = "2018-03-29";

    public void insertAssets() throws IOException {
        File[] files = assetReaderService.readAllPaths(FOLDER_PATH);
        for (File file : files) {
            List<AssetNode> assetNodes = assetReaderService.readAssets(file);
            Date registeredAt = Date.valueOf(NOTICE_DATE);
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
                    case VEHICLE:
                        VehicleSaveCommand vehicleSaveCommand = new VehicleSaveCommand(assetParserService, vehicleRepository);
                        saveCommandExecutor.executeCommand(vehicleSaveCommand, assetNode, registeredAt);
                        break;
                }
            }
        }

    }

}