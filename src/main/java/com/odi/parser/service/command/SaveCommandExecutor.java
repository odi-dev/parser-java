package com.odi.parser.service.command;

import com.odi.parser.model.asset.AssetNode;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SaveCommandExecutor {

    private final List<AssetSaveCommand> saveCommandList = new ArrayList<>();

    public void executeCommand(AssetSaveCommand saveCommand, AssetNode assetNode, Date registeredAt) {
        saveCommandList.add(saveCommand);
        saveCommand.execute(assetNode, registeredAt);
    }

}
