package com.odi.parser.component;

import com.odi.parser.model.AssetResult;
import com.odi.parser.model.Member;
import com.odi.parser.model.Relation;
import com.odi.parser.model.asset.Land;
import com.odi.parser.repository.LandRepository;
import com.odi.parser.repository.MemberRepository;
import com.odi.parser.repository.RelationRepository;
import com.odi.parser.service.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

@Component
public class AssetParser {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RelationRepository relationRepository;

    @Autowired
    LandRepository landRepository;

    public AssetResult parseAssetResult(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        InputStream inputStream = resource.getInputStream();

        AssetResult assetResult = JsonUtil.toObject(inputStream, AssetResult.class);
        return assetResult;
    }

    public void saveLands() throws IOException {
        String path = "json/test.json";
        AssetResult assetResult = parseAssetResult(path);
        Member member = memberRepository.findByName(assetResult.getName()).get(0);

        List<Land> lands = assetResult.getAsset().getLand();
        for (Land land : lands) {
            Date registeredAt = Date.valueOf("2018-03-29");

            if(!isDuplicateLand(land, registeredAt)) {
                Relation relation = relationRepository.findByType(land.getRelation().name());
                land.setMemberId(member.getId());
                land.setRelationId(relation.getId());
                land.setRegisteredAt(registeredAt);
                landRepository.save(land);
            }

        }
    }

    private boolean isDuplicateLand(Land land, Date registeredAt) {
        return landRepository.findByDescriptionAndRegisteredAt(land.getDescription(), registeredAt) != null;
    }
}
