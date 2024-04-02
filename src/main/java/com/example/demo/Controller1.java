package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")

public class Controller1 {
    @GetMapping
    public  String welcome(){
        return "Welcome to the webpage everyone!";
    }

    @GetMapping("/user")
    public  String welcomeUser(){
        return "Welcome to the webpage user and admin only!";
    }

    @GetMapping("/admin")
    public  String welcomeAdmin(){
        return "Welcome to the webpage admin only!";
    }
}
