package com.odi.parser.model.asset;

import com.odi.parser.model.Relation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetAbstractEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date registeredAt;
    private Long memberId;

    @OneToOne
    @JoinColumn(name = "relation")
    private Relation relation;
    private String type;
    private Long lastPrice;
    private Long price;
    private String description;
    private String reason;

}
