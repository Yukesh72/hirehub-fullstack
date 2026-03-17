package com.example.hirehub.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Autowired
    private JWTfilter jw;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {

        http
                .cors(cors->{})
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/userlogin/login/**",
                                "/api/userlogin/register/**").permitAll()
                        .requestMatchers("/api/userlogin/admin/**",
                                "/api/jobdetails/admin/**",
                                "/api/applyportal/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/api/userlogin/user/**",
                                "/api/jobdetails/user/**",
                                "/api/applyportal/user/**").hasAuthority("USER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable());


        http
                .addFilterBefore(jw, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

