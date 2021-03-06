package com.odi.parser.service;

import com.odi.parser.model.Member;
import com.odi.parser.model.Relation;
import com.odi.parser.model.asset.*;
import com.odi.parser.repository.MemberRepository;
import com.odi.parser.repository.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssetParserService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RelationRepository relationRepository;

    public Land convertAssetNodeToLand(AssetNode assetNode, Date registeredAt) throws Exception {
        Member member = getMemberByName(assetNode.getName());
        Relation relation = relationRepository.findByType(assetNode.getRelationType().name());

        return Land.builder()
                .registeredAt(registeredAt)
                .memberId(member.getId())
                .relation(relation)
                .type(assetNode.getType())
                .lastPrice(assetNode.getLastPrice())
                .price(assetNode.getPrice())
                .description(assetNode.getDescription())
                .reason(assetNode.getReason())
                .build();
    }

    public Building convertAssetNodeToBuilding(AssetNode assetNode, Date registeredAt) throws Exception {
        Member member = getMemberByName(assetNode.getName());
        Relation relation = relationRepository.findByType(assetNode.getRelationType().name());

        return Building.builder()
                .registeredAt(registeredAt)
                .memberId(member.getId())
                .relation(relation)
                .type(assetNode.getType())
                .lastPrice(assetNode.getLastPrice())
                .price(assetNode.getPrice())
                .description(assetNode.getDescription())
                .reason(assetNode.getReason())
                .build();
    }

    public Vehicle convertAssetNodeToVehicle(AssetNode assetNode, Date registeredAt) throws Exception {
        Member member = getMemberByName(assetNode.getName());
        Relation relation = relationRepository.findByType(assetNode.getRelationType().name());

        return Vehicle.builder()
                .registeredAt(registeredAt)
                .memberId(member.getId())
                .relation(relation)
                .type(assetNode.getType())
                .lastPrice(assetNode.getLastPrice())
                .price(assetNode.getPrice())
                .description(assetNode.getDescription())
                .reason(assetNode.getReason())
                .build();
    }

    public Cash convertAssetNodeToCash(AssetNode assetNode, Date registeredAt) throws Exception {
        Member member = getMemberByName(assetNode.getName());
        Relation relation = relationRepository.findByType(assetNode.getRelationType().name());

        return Cash.builder()
                .registeredAt(registeredAt)
                .memberId(member.getId())
                .relation(relation)
                .type(assetNode.getType())
                .lastPrice(assetNode.getLastPrice())
                .price(assetNode.getPrice())
                .description(assetNode.getDescription())
                .reason(assetNode.getReason())
                .build();
    }

    public Stock convertAssetNodeToStock(AssetNode assetNode, Date registeredAt) throws Exception {
        Member member = getMemberByName(assetNode.getName());
        Relation relation = relationRepository.findByType(assetNode.getRelationType().name());

        return Stock.builder()
                .registeredAt(registeredAt)
                .memberId(member.getId())
                .relation(relation)
                .type(assetNode.getType())
                .lastPrice(assetNode.getLastPrice())
                .price(assetNode.getPrice())
                .description(assetNode.getDescription())
                .reason(assetNode.getReason())
                .build();
    }

    private Member getMemberByName(String name) {
        List<Member> members = new ArrayList<>();
        if(name.contains("(")) {
            String[] split = name.split("\\(");
            name = split[0];
            String name_zh = split[1].replace(")", "");
            members = memberRepository.findByNameAndZh(name, name_zh);
        } else {
            members = memberRepository.findByName(name);
        }

        int size = members.size();
        if(size == 0) {
            throw new RuntimeException("Can not find members");
        } else if(size > 1) {
            throw new RuntimeException("Duplicated members");
        }

        return members.get(0);
    }

}
