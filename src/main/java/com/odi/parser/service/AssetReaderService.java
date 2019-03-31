package com.odi.parser.service;

import com.odi.parser.model.asset.AssetNode;
import com.odi.parser.model.enums.AssetType;
import com.odi.parser.model.enums.RelationType;
import com.opencsv.CSVReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AssetReaderService {

    public List<AssetNode> readAssets() throws IOException {
        String path = "csv/data1.csv";
        CSVReader csvReader = new CSVReader(new FileReader(new ClassPathResource(path).getFile()));

        String name;
        String[] line;
        if((line = csvReader.readNext()) != null && hasName(line)) {
            name = line[5].trim();
        } else {
            throw new NoSuchElementException("Can not find name");
        }


        List<AssetNode> assetNodes = new ArrayList<>();
        AssetType currAssetType = null;
        while ((line = csvReader.readNext()) != null) {
            if(line[0].isEmpty() || line[0].contains("총계") || line[0].contains("본인과의 관계") || line[0].contains("증가액 (실거래액)"))
                continue;

            if(line[0].contains("▶")) {
                String assetDesc = line[0].replace("▶", "").trim();
                currAssetType = AssetType.descOf(assetDesc);
            } else if(currAssetType != null) {
                RelationType relationType = RelationType.valueOf(line[0].trim());
                AssetNode currAssetNode = new AssetNode(currAssetType, name);
                currAssetNode.setRelationType(relationType);
                currAssetNode.setType(line[1].trim());
                currAssetNode.setDescription(line[2].trim());
                currAssetNode.setLastPrice(line[3].trim());
                currAssetNode.setPrice(line[6].trim());
                currAssetNode.setReason(line[7].trim());

                assetNodes.add(currAssetNode);
            }
        }
        return assetNodes;
    }

    private boolean hasName(String[] line) {
        for(String str : line)
            if(str.contains("성명"))
                return true;

        return false;
    }
}
