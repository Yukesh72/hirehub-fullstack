package com.example.hirehub.DTO;

import com.example.hirehub.model.user;

public class LoginResponse
{
    private String token;
    private user user;

    public LoginResponse(String token, user user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public user getUser() {
        return user;
    }
}
