package com.udacity.jwdnd.course1.cloudstorage.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loginUser")
public class LoginController {

    @GetMapping
    public String loginUser(){
        return "login";
    }

}
