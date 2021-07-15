package com.example.ilaboratory.repository;

import com.example.ilaboratory.domain.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {
    @Modifying
    @Query("delete from Assignment a where a.aid=:aid")
    void deleteById(@Param("aid") Long aid);
}
