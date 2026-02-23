package com.example.hirehub.repository;

import com.example.hirehub.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Repository1 extends JpaRepository<user,Integer>
{
    user findByEmail(String email);
    Optional<user> findByemail(String email);
}
