package com.odi.parser.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssetParserTest {

    @Autowired
    AssetParser assetParser;

    @Test
    public void parseAssetResult() throws Exception {
        String path = "json/test.json";
        System.out.println(assetParser.parseAssetResult(path));
    }

    @Test
    public void saveAssets() throws Exception {
        assetParser.saveAssets();
    }

}
