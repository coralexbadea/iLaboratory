package com.example.ilaboratory.repository;

import com.example.ilaboratory.domain.Student;
import com.example.ilaboratory.domain.Submit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmitRepository extends CrudRepository<Submit, Long> {
    List<Submit> findAllByAssignment_Aid(Long id);
    List<Submit> findAllByAssignment_AidAndStudent1_Sid(Long id, Long uid);

    @Modifying
    @Query("delete from Submit s where s.id=:id")
    void deleteById(@Param("id") Long id);
}
