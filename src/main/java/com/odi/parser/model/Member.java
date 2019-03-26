package com.odi.parser.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("empNm")
    private String name;

    @JsonProperty("engNm")
    private String nameEn;

    @JsonProperty("hjNm")
    private String nameZh;

    @JsonProperty("bthDate")
    private String birthDate;

    @JsonProperty("polyNm")
    private String party;

    @JsonProperty("origNm")
    private String precinct;

    @JsonProperty("shrtNm")
    private String committee;

    @JsonProperty("reeleGbnNm")
    private String electedCount;

    @JsonProperty("electionNum")
    private String electedNumber;

    @JsonProperty("assemTel")
    private String officePhone;

    @JsonProperty("assemHomep")
    private String homepage;

    @JsonProperty("assemEmail")
    private String email;

    @JsonProperty("staff")
    private String staff;

    @JsonProperty("secretary")
    private String secretary;

    @JsonProperty("secretary2")
    private String assistant;

    @JsonProperty("hbbyCd")
    private String hobby;

    @JsonProperty("examCd")
    private String speciality;

    @JsonProperty("memTitle")
    private String profile;

    private Date updatedAt;

    private Integer idCode;

}
