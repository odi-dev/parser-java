package com.odi.parser.service;

import com.odi.parser.model.asset.AssetNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssetReaderServiceTest {

    @Autowired
    AssetReaderService assetReaderService;

    @Test
    public void readAllPaths() throws Exception {
        String folder = "csv/";
        File[] files = assetReaderService.readAllPaths(folder);
        for(File file : files)
            System.out.println(file);
    }

    @Test
    public void readAssets() throws Exception {
        String folder = "csv/";
        File[] files = assetReaderService.readAllPaths(folder);
        List<AssetNode> assetNodes = assetReaderService.readAssets(files[0]);
        System.out.println(assetNodes);
    }

    @Test
    public void readAllAssets() throws Exception {
        String folder = "csv/";
        File[] files = assetReaderService.readAllPaths(folder);
        for (File file : files) {
            List<AssetNode> assetNodes = assetReaderService.readAssets(file);
            System.out.println(assetNodes);
        }
    }

}
