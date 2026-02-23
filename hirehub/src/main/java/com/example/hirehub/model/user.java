package com.example.hirehub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class user
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;


    public String getpassword()
    {
        return password;
    }

    public String getemail()
    {
        return email;
    }

    public void setRole(String role)
    {
        this.role=role;
    }

    public String getName()
    {
        return name;
    }
}
