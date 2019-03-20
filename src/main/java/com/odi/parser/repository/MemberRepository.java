package com.odi.parser.repository;

import com.odi.parser.model.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends CrudRepository<Member, Long> {

    @Query(value = "select * from member where id_code = :idCode", nativeQuery = true)
    Member findByIdCode(@Param("idCode") int idCode);

}
