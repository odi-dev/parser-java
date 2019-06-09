package com.odi.parser.service.command;

import com.odi.parser.model.asset.AssetNode;
import com.odi.parser.model.asset.Stock;
import com.odi.parser.repository.StockRepository;
import com.odi.parser.service.AssetParserService;

import java.sql.Date;

public class StockSaveCommand implements AssetSaveCommand {

    private AssetParserService assetParserService;
    private StockRepository stockRepository;

    public StockSaveCommand(AssetParserService assetParserService, StockRepository stockRepository) {
        this.assetParserService = assetParserService;
        this.stockRepository = stockRepository;
    }


    @Override
    public void execute(AssetNode assetNode, Date registeredAt) {
        try {
            Stock stock = assetParserService.convertAssetNodeToStock(assetNode, registeredAt);
            if(stockRepository.findByMemberIdAndDescriptionAndRegisteredAtAndRelation(stock.getMemberId(), stock.getDescription(), stock.getRegisteredAt(), stock.getRelationId()) == null)
                stockRepository.save(stock);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
