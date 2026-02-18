package com.example.hirehub.control;

import com.example.hirehub.repository.Repository1;
import com.example.hirehub.service.service1;
import com.example.hirehub.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userlogin")
@CrossOrigin(origins ="*")
public class control1
{
    @Autowired
    service1 s1;

    @Autowired
    Repository1 r1;

    @PostMapping(value = "/register",consumes = "application/json")
    public user reg(@RequestBody user u)
    {
        user userexist = r1.findByEmail(u.getemail());

        if(userexist!=null)
        {
            throw new RuntimeException("User Already Exist !");
        }

        u.setRole("USER");
        return r1.save(u);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody user u)
    {
        user loggedUser = s1.login(u.getemail(), u.getpassword());

        if (loggedUser == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }

        return ResponseEntity.ok(loggedUser);
    }

    @GetMapping("/count")
    public Long usercount()
    {
        return r1.count();
    }
}
