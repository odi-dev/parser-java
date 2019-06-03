package com.odi.parser.component;

import com.odi.parser.model.asset.AssetNode;
import com.odi.parser.model.enums.AssetType;
import com.odi.parser.repository.BuildingRepository;
import com.odi.parser.repository.CashRepository;
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

    @Autowired
    CashRepository cashRepository;

    public final static String FOLDER_PATH = "csv/";
    public final static String NOTICE_DATE = "2018-03-29";

    public void insertAssets() throws IOException {
        File[] files = assetReaderService.readAllPaths(FOLDER_PATH);
        for (File file : files) {
            List<AssetNode> assetNodes = assetReaderService.readAssets(file);
            Date registeredAt = Date.valueOf(NOTICE_DATE);
            SaveCommandExecutor saveCommandExecutor = new SaveCommandExecutor();

            for(AssetNode assetNode : assetNodes) {
                AssetSaveCommand assetSaveCommand = getCommandByAssetType(assetNode.getAssetType());
                if(assetSaveCommand != null) {
                    saveCommandExecutor.executeCommand(assetSaveCommand, assetNode, registeredAt);
                }
            }
        }

    }

    private AssetSaveCommand getCommandByAssetType(AssetType assetType) {
        switch (assetType) {
            case LAND:
                return new LandSaveCommand(assetParserService, landRepository);
            case BUILDING:
                return new BuildingSaveCommand(assetParserService, buildingRepository);
            case VEHICLE:
                return new VehicleSaveCommand(assetParserService, vehicleRepository);
            case CASH:
                return new CashSaveCommand(assetParserService, cashRepository);
            case GEM:
            case BOND:
            case DEPT:
            case GOLD:
            case STOCK:
            case ANTIQUE:
            case DEPOSIT:
            case MEMBERSHIP:
            case POLITICAL_FUND:
            case NONPROFIT_CORPORATION:
            case DENIAL_NOTICE:
                return null;
            default:
                throw new RuntimeException();
        }
    }

}
