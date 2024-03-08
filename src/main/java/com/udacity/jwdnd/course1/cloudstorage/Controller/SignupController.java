package com.udacity.jwdnd.course1.cloudstorage.Controller;

import com.udacity.jwdnd.course1.cloudstorage.Entity.Users;
import com.udacity.jwdnd.course1.cloudstorage.Mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private UserService userService;
    private UserMapper userMapper;
    public SignupController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public String signUpUser(){
        return "signup";
    }

    @PostMapping
    public String signupUser(Users users, Model model, Authentication authentication) {
        String signupError = null;

        if (!userService.checkUserAlreadyExists(users.getUsername())) {
            signupError = "user already exists";
        }
        if (signupError == null) {
            int rowsAdded = userService.createUser(users);
            if (rowsAdded < 0) {
                signupError = "There was an error signing you up. Please try again.";
            }
        }
        if (signupError == null) {
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", signupError);
        }
        String userName = authentication.getName();
        System.out.println("user id is " + userMapper.getUserId(users.getUsername()));
        System.out.println("Authenticated user id is " + userName);
        return "signup";
    }
}
