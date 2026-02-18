package com.example.hirehub.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hirehub.service.applyserice;
import com.example.hirehub.model.apply;
import com.example.hirehub.repository.applyrep;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applyportal")
@CrossOrigin(origins ="*")
public class applycontrol
{
    @Autowired
    applyserice as;

    @Autowired
    applyrep a1;

    @PostMapping(value = "/apply",consumes = "application/json")
    public ResponseEntity<?> getuser(@RequestBody apply a)
    {
        try
        {
            return ResponseEntity.ok(as.loginexist(a));
        }
        catch (RuntimeException e)
        {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

        @GetMapping("/userid/{userid}")
        public List<apply> getuserid (@PathVariable Long userid)
        {
            return as.userIds(userid);
        }

        @GetMapping("/jobid/{jobid}")
        public List<apply> getjobid (@PathVariable Long jobid)
        {
            return as.jobIds(jobid);
        }

        @PutMapping("/applystatus/{applyid}")
        public apply updstatus(@PathVariable Long applyid,
                               @RequestParam String status)
        {
            return as.updatestatus(applyid,status);
        }

        @GetMapping("/all")
        public List<apply> getallapl()
        {
            return as.getall();
        }

        @GetMapping("/count")
        public Long usercount()
        {
            return a1.count();
        }
        @GetMapping("/applystatusget/{status}")
        public Long countstatus(@PathVariable String status)
        {
            return a1.countByStatus(status);
        }

        @GetMapping("/getstatus/status/{status}")
        public List<apply> getbystatuss(@PathVariable String status)
        {
            return as.getbystatus(status);
        }

        @GetMapping("/getuser/{userid}")
        public List<apply> getuserid(@PathVariable Long userid,@RequestParam(required = false)String status)
        {
            return as.viewbystatus(userid,status);
        }

        @PutMapping("/withdraw/{applyid}")
        public apply withdraw(@PathVariable Long applyid)
        {
            return as.withdrawapplication(applyid);
        }

    @GetMapping("/getinfobyapply/{id}")
    public ResponseEntity<apply> getInfo(@PathVariable Long id)
    {
        return a1.findByApplyIdWithJob(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }













}
