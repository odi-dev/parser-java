package com.odi.parser.repository;

import com.odi.parser.model.asset.Land;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface LandRepository extends CrudRepository<Land, Long> {

    @Query(value = "select * from land where member_id = :memberId and description = :description and registered_at = :registered_at and relation = :relation", nativeQuery = true)
    Land findByMemberIdAndDescriptionAndRegisteredAtAndRelation(@Param("memberId") Long memberId, @Param("description") String description, @Param("registered_at") Date registeredAt, @Param("relation") Long relation);
}
