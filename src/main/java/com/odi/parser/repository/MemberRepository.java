package com.odi.parser.repository;

import com.odi.parser.model.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {

    @Query(value = "select * from member where id_code = :idCode", nativeQuery = true)
    Member findByIdCode(@Param("idCode") int idCode);

    @Query(value = "select * from member where name = :name", nativeQuery = true)
    List<Member> findByName(@Param("name") String name);

    @Query(value = "select * from member where name = :name and name_zh = :name_zh", nativeQuery = true)
    List<Member> findByNameAndZh(@Param("name") String name, @Param("name_zh") String name_zh);

}
