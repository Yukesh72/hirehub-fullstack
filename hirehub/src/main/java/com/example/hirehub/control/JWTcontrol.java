package com.example.hirehub.control;

import com.example.hirehub.JWTutil;
import com.example.hirehub.model.user;
import com.example.hirehub.repository.Repository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class JWTcontrol
{
    @Autowired
    private Repository1 rep;

    @Autowired
    private JWTutil jwt;

    @PostMapping("/loginauth")
    public ResponseEntity<?> JwtAuth(@RequestBody user u)
    {
        user dbusers=rep.findByemail(u.getemail()).orElseThrow(()->new RuntimeException("cannot find email"));

        if(!dbusers.getpassword().equals(u.getpassword()))
        {
            throw new RuntimeException("wrong password bro");
        }
        String token=jwt.gentoken(dbusers.getemail());

        return ResponseEntity.ok(token);
    }
}
