package com.odi.parser.service.command;

import com.odi.parser.model.asset.AssetNode;
import com.odi.parser.model.asset.Land;
import com.odi.parser.model.asset.Vehicle;
import com.odi.parser.repository.LandRepository;
import com.odi.parser.repository.VehicleRepository;
import com.odi.parser.service.AssetParserService;

import java.sql.Date;

public class VehicleSaveCommand implements AssetSaveCommand {

    private AssetParserService assetParserService;
    private VehicleRepository vehicleRepository;

    public VehicleSaveCommand(AssetParserService assetParserService, VehicleRepository vehicleRepository) {
        this.assetParserService = assetParserService;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void execute(AssetNode assetNode, Date registeredAt) {
        Vehicle vehicle = assetParserService.convertAssetNodeToVehicle(assetNode, registeredAt);
        if(vehicleRepository.findByDescriptionAndRegisteredAt(vehicle.getDescription(), vehicle.getRegisteredAt()) == null)
            vehicleRepository.save(vehicle);
    }

}
