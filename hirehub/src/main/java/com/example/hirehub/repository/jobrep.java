package com.example.hirehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hirehub.model.job;
import java.util.List;

@Repository
public interface jobrep extends JpaRepository<job,Long>
{
    List<job> findByTitleContainingIgnoreCase(String keyword);
}
