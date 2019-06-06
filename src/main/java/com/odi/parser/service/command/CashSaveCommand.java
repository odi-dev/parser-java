package com.odi.parser.service.command;

import com.odi.parser.model.asset.AssetNode;
import com.odi.parser.model.asset.Cash;
import com.odi.parser.repository.CashRepository;
import com.odi.parser.service.AssetParserService;

import java.sql.Date;

public class CashSaveCommand implements AssetSaveCommand {

    private AssetParserService assetParserService;
    private CashRepository cashRepository;

    public CashSaveCommand(AssetParserService assetParserService, CashRepository cashRepository) {
        this.assetParserService = assetParserService;
        this.cashRepository = cashRepository;
    }

    @Override
    public void execute(AssetNode assetNode, Date registeredAt) {
        try {
            Cash cash = assetParserService.convertAssetNodeToCash(assetNode, registeredAt);
            if(cashRepository.findByMemberIdAndDescriptionAndRegisteredAt(cash.getMemberId(), cash.getDescription(), cash.getRegisteredAt()) == null)
                cashRepository.save(cash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
