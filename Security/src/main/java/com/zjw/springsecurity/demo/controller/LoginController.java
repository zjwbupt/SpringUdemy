package com.zjw.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
    //why we put access-denied mapping here? because, once we logged into the user,
    //spring security will take the other part.
}
