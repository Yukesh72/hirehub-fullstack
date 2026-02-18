package com.example.hirehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.hirehub.model.apply;

import java.util.List;
import java.util.Optional;

@Repository
public interface applyrep extends JpaRepository<apply,Long>
{
    List<apply> findByuserid(Long userid);
    List<apply> findByjobid(Long jobid);
    boolean existsByUseridAndJobid(Long userid,Long jobid);
    Long countByStatus(String status);
    List<apply> findByStatus(String status);
    List<apply> findByuseridAndStatus(Long userid, String status);

    @Query("""
    SELECT a FROM apply a
    JOIN FETCH a.jobs
    WHERE a.applyid = :id
""")
    Optional<apply> findByApplyIdWithJob(@Param("id") Long id);


}
