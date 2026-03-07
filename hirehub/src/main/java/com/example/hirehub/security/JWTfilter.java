package com.example.hirehub.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTfilter extends OncePerRequestFilter
{
    @Autowired
    private JWTutil jw;

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain fc)
                                    throws ServletException, IOException
    {
        String authhead=req.getHeader("Authorization");

        if(authhead!=null&&authhead.startsWith("Bearer"))
        {
            String token=authhead.substring(7);

            String email=jw.extractEmail(token);

            if(email!=null)
            {
                System.out.println("valid token : "+ email);
            }

        }
        fc.doFilter(req,res);
    }

}
