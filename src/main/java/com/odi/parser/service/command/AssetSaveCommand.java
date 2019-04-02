package com.odi.parser.service.command;

import com.odi.parser.model.asset.AssetNode;

import java.sql.Date;

public interface AssetSaveCommand {

    public void execute(AssetNode assetNode, Date registeredAt);
}
