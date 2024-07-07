package com.example.The.Big.Project.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/api")
    public String getGreeting(){
        return "Hello 102Foxtrot!";
    }
}
