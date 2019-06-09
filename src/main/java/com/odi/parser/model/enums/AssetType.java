package com.odi.parser.model.enums;

import java.util.Arrays;

public enum AssetType {
    LAND("토지(소계)"),
    BUILDING("건물(소계)"),
    // VEHICLE("부동산에 관한 규정이 준용되는 권리와 자동차 건설기계 선박 및 항공기(소계)"), // 2018
    VEHICLE("부동산에 관한 규정이 준용되는 권리와 자동차.건설기계.선박 및 항공기(소계)"), // 2019
    DEPOSIT("예금(소계)"),
    DEPT("채무(소계)"),
    STOCK("유가증권(소계)"),
    GEM("보석류(소계)"),
    // GOLD("금 및 백금(소계)"), // 2018
    GOLD("금및백금(소계)"), // 2019
    CASH("현금(소계)"),
    MEMBERSHIP("회원권(소계)"),
    NONPROFIT_CORPORATION("비영리법인에 출연한 재산"),
    POLITICAL_FUND("정치자금법에 따른 정치자금의 수입 및 지출을 위한 예금계좌의 예금(소계)"),
    BOND("채권(소계)"),
    ANTIQUE("골동품 및 예술품(소계)"),
    EQUITY_INTEREST("합명.합자.유한회사 출자지분(소계)"),
    IPR("지식재산권"),
    DENIAL_NOTICE("고지거부 및 등록제외사항(소계)");

    AssetType(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }

    public static AssetType descOf(String desc) {
        return Arrays.stream(values())
                .filter(v -> desc.equals(v.desc))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
