package com.odi.parser.component;

import com.odi.parser.model.Member;
import com.odi.parser.model.nationalassembly.CurrStateResponse;
import com.odi.parser.model.nationalassembly.MemberDetailResponse;
import com.odi.parser.repository.MemberRepository;
import com.odi.parser.service.MemberParserService;
import com.odi.parser.service.NationalAssemblyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class MemberClient {

    @Autowired
    NationalAssemblyInfoService nationalAssemblyInfoService;

    @Autowired
    MemberParserService memberParserService;

    @Autowired
    MemberRepository memberRepository;

    public void insertCurrMembers() throws IOException, URISyntaxException {
        List<CurrStateResponse> memberCurrStateList = nationalAssemblyInfoService.getMemberCurrStateList();
        for (CurrStateResponse currStateResponse : memberCurrStateList) {
            int deptCd = currStateResponse.getDeptCd();
            int num = currStateResponse.getNum();

            MemberDetailResponse memberDetailInfo = nationalAssemblyInfoService.getMemberDetailInfo(deptCd, num);
            Member member = memberParserService.convertResponseToMember(memberDetailInfo, num);

            if(!isDuplicatedMember(member))
                memberRepository.save(member);
        }
    }

    private boolean isDuplicatedMember(Member member) {
        return memberRepository.findByIdCode(member.getIdCode()) != null;
    }


}
