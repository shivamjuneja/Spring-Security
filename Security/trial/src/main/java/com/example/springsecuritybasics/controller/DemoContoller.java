package com.example.springsecuritybasics.controller;

import com.example.springsecuritybasics.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoContoller {

    @Autowired
    InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @PostMapping("/create")
    public String createUserPost(@RequestBody User user){

        System.out.println(user.getUsername()+"---------"+user.getPassword());
        UserDetails user1 = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities("admin")
                .build();
        inMemoryUserDetailsManager.createUser(user1);
        return "created user";
    }

    @GetMapping("/")
    public String createUser(){

        return "Welcome";
    }
    @GetMapping("/hello")
    public String helloUser(){

        return "hello endpoint";
    }
}
