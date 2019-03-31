package com.odi.parser.service;

import com.odi.parser.model.Member;
import com.odi.parser.model.nationalassembly.MemberDetailResponse;
import com.odi.parser.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class MemberParserService {

    @Autowired
    NationalAssemblyInfoService nationalAssemblyInfoService;

    @Autowired
    MemberRepository memberRepository;

    public Member convertResponseToMember(MemberDetailResponse response, int num) {
        return Member.builder()
                .name(response.getEmpNm())
                .nameEn(response.getEngNm())
                .nameZh(response.getHjNm())
                .birthDate(response.getBthDate())
                .party(response.getPolyNm())
                .precinct(response.getOrigNm())
                .committee(response.getShrtNm())
                .electedCount(response.getReeleGbnNm())
                .electedNumber(response.getElectionNum())
                .officePhone(response.getAssemTel())
                .homepage(response.getAssemHomep())
                .email(response.getAssemEmail())
                .staff(response.getStaff())
                .secretary(response.getSecretary())
                .assistant(response.getSecretary2())
                .hobby(response.getHbbyCd())
                .speciality(response.getExamCd())
                .profile(response.getMemTitle())
                .updatedAt(Date.valueOf(LocalDate.now()))
                .idCode(num)
                .build();
    }

}
