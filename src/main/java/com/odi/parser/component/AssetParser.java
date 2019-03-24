package com.odi.parser.component;

import com.odi.parser.model.AssetResult;
import com.odi.parser.service.util.JsonUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class AssetParser {

    public AssetResult parseAssetResult(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        InputStream inputStream = resource.getInputStream();

        AssetResult assetResult = JsonUtil.toObject(inputStream, AssetResult.class);
        return assetResult;
    }
}
