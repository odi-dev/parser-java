package com.odi.parser.repository;

import com.odi.parser.model.Relation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RelationRepository extends CrudRepository<Relation, Long> {

    @Query(value = "select * from relation where type = :type", nativeQuery = true)
    Relation findByType(@Param("type") String type);
}
