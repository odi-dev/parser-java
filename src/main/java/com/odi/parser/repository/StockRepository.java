package com.odi.parser.repository;

import com.odi.parser.model.asset.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface StockRepository extends CrudRepository<Stock, Long> {

    @Query(value = "select * from stock where member_id = :memberId and description = :description and registered_at = :registered_at and relation = :relation", nativeQuery = true)
    Stock findByMemberIdAndDescriptionAndRegisteredAtAndRelation(@Param("memberId") Long memberId, @Param("description") String description, @Param("registered_at") Date registeredAt, @Param("relation") Long relation);
}
