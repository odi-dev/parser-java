package com.odi.parser.model;

import com.odi.parser.model.enums.RelationType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
public class Relation {

    @Id
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RelationType type;
}
