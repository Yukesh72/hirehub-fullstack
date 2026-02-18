package com.example.hirehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hirehub.model.job;

@Repository
public interface jobrep extends JpaRepository<job,Long>
{

}
