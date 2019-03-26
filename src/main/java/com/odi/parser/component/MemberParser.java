package com.odi.parser.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.odi.parser.model.Member;
import com.odi.parser.repository.MemberRepository;
import com.odi.parser.service.NationalAssemblyInfoService;
import com.odi.parser.service.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemberParser {

    @Autowired
    NationalAssemblyInfoService nationalAssemblyInfoService;

    @Autowired
    MemberRepository memberRepository;

    public List<Member> parseMembers() throws IOException, URISyntaxException {
        List<Member> members = new ArrayList<>();

        ResponseEntity<String> responseCurr = nationalAssemblyInfoService.getMemberCurrStateList();
        JsonNode list = JsonUtil.toJsonNode(responseCurr.getBody()).get("response").get("body").get("items").get("item");

        for(JsonNode item : list) {
            int deptCd = JsonUtil.toValue(item.get("deptCd"), Integer.class);
            int num = JsonUtil.toValue(item.get("num"), Integer.class);
            ResponseEntity<String> responseDetail = nationalAssemblyInfoService.getMemberDetailInfoList(deptCd, num);
            Member member = JsonUtil.toObject(JsonUtil.toJsonNode(responseDetail.getBody()).get("response").get("body").get("item").toString(), Member.class);
            member.setIdCode(num);
            members.add(member);
        }

        return members;
    }

    public void saveMembers() throws IOException, URISyntaxException {
        List<Member> members = parseMembers();
        for (Member member : members) {
            if(!isDuplicateMember(member)) {
                member.setUpdatedAt(Date.valueOf(LocalDate.now()));
                memberRepository.save(member);
            }
        }
    }

    private boolean isDuplicateMember(Member member) {
        return memberRepository.findByIdCode(member.getIdCode()) != null;
    }

}
