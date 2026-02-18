package com.example.hirehub.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Entity
@Data
public class apply
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applyid;

    private Long userid;
    private long jobid;

    @Column(nullable = false)
    private String status="APPLIED";

    @ManyToOne
    @JoinColumn(name = "job_id")
    private job jobs;


    public void setStatus(String status)
    {
        this.status=status;
    }

    public String getStatus()
    {
        return status;
    }

    public Long getUserid()
    {
        return userid;
    }

    public Long getJobid()
    {
        return jobid;
    }


}
