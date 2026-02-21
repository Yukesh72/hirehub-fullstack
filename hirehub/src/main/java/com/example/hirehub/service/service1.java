package com.example.hirehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hirehub.repository.Repository1;
import com.example.hirehub.model.user;

@Service
public class service1
{
    @Autowired
    Repository1 r1;


    public user registration(user s)
    {
        return r1.save(s);
    }

    public user login(String email, String password)
    {

        user users = r1.findByEmail(email);

        if (users != null&&users.getpassword().equals(password))
        {
            return users;
        }

        return null;
    }

}
