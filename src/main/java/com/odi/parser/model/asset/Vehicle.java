package com.odi.parser.model.asset;

import com.odi.parser.model.Relation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Date registeredAt;
    private Integer memberId;

    @OneToOne
    @JoinColumn(name = "relation")
    private Relation relation;
    private String type;
    private Integer lastPrice;
    private Integer price;
    private String description;
    private String reason;

}
