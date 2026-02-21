package com.example.hirehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hirehub.repository.jobrep;
import com.example.hirehub.model.job;

import java.util.List;

@Service
public class jobservice
{
    @Autowired
    jobrep jr;

    public job savejob(job j)
    {
        return jr.save(j);
    }

    public List<job> getAlljobs()
    {
        return jr.findAll();
    }

    public job getJobById(Long id)
    {
        return jr.findById(id).orElse(null);
    }

}
