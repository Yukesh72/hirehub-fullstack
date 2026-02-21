package com.example.hirehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.hirehub.model.apply;
import com.example.hirehub.repository.applyrep;

import java.util.List;
import java.util.Optional;

@Service
public class applyserice
{
    @Autowired
    applyrep ar;

    public apply saveuser(apply a)
    {
        a.setStatus("APPLIED");
        return ar.save(a);
    }

    public List<apply> userIds(Long userid)
    {
        return ar.findByuserid(userid);
    }

    public List<apply> jobIds(Long jobid)
    {
        return ar. findByJobid(jobid);
    }

    public apply loginexist(apply a)
    {
        boolean alreadyApplied = ar.existsByUseridAndJobid(a.getUserid(), a.getJobid());
        if(alreadyApplied)
        {
            throw new RuntimeException("Already applied for this job!");
        }
        return ar.save(a);
    }

    public apply updatestatus(Long applyid,String status)
    {
        apply a = ar.findById(applyid).orElseThrow(() -> new RuntimeException("application not found"));

        a.setStatus(status);
        return ar.save(a);
    }

    public List<apply> getall()
    {
         return ar.findAll();
    }

    public List<apply> getbystatus(String status)
    {
        return ar.findByStatus(status);
    }

    public List<apply> viewbystatus(Long userid,String status)
    {
        if(status==null||status.isEmpty())
        {
            return ar.findByuserid(userid);
        }
        return ar.findByuseridAndStatus(userid,status);
    }

    public apply withdrawapplication(Long applyid)
    {
        apply a=ar.findById(applyid).orElseThrow(()->new RuntimeException("Application not found!"));
        a.setStatus("WITHDRAWN");
        return ar.save(a);

    }









}
