package com.example.hirehub.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.hirehub.model.job;
import com.example.hirehub.service.jobservice;
import com.example.hirehub.repository.jobrep;

import java.util.List;

@RestController
@RequestMapping("/api/jobdetails")
@CrossOrigin(origins ="*")
public class jobcontrol
{
    @Autowired
    jobservice js;

    @Autowired
    jobrep j1;

    @PostMapping("/addjobdetails")
    public job addjob(@RequestBody job j)
    {
        return js.savejob(j);
    }

    @GetMapping("/showjobdetails")
    public List<job> showjobdetails()
    {
        return js.getAlljobs();
    }

    @GetMapping("/{id}")
    public job getJobById(@PathVariable Long id)
    {
        return js.getJobById(id);
    }

    @GetMapping("/count")
    public Long usercount()
    {
        return j1.count();
    }

}
