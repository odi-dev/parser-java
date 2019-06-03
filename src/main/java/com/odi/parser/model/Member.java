package com.odi.parser.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nameEn;
    private String nameZh;
    private String birthDate;
    private String party;
    private String precinct;
    private String committee;
    private String electedCount;
    private String electedNumber;
    private String officePhone;
    private String homepage;
    private String email;
    private String staff;
    private String secretary;
    private String assistant;
    private String hobby;
    private String speciality;
    private String profile;
    private Date updatedAt;
    private Integer idCode;

}
