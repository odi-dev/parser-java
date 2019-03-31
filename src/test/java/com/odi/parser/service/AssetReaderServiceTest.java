package com.odi.parser.service;

import com.odi.parser.model.asset.AssetNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssetReaderServiceTest {

    @Autowired
    AssetReaderService assetReaderService;

    @Test
    public void readAssets() throws Exception {
        List<AssetNode> assetNodes = assetReaderService.readAssets();
        System.out.println(assetNodes);
    }

}
