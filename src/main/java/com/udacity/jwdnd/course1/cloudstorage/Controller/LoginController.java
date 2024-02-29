package com.udacity.jwdnd.course1.cloudstorage.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String loginUser(){
        return "login";
    }

    @GetMapping
    public String validateUserCredentials(@RequestParam String username, @RequestParam String password){
        // TO-DO authenticate the username and password

        return "home";
    }
}
