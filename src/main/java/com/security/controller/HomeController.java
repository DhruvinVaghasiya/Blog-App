package com.security.controller;

import com.security.model.UserDtls;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/createUser")
    private String createUser(@ModelAttribute UserDtls user, HttpSession session) {
        boolean f = userService.checkEmail(user.getEmail());
        if (f) {
            session.setAttribute("msg","Email id alredy Exist");
            System.out.println("Email id alredy Exist");
        } else {

            //  System.out.println(user);
            UserDtls userDtls = userService.createUser(user);
            if (userDtls != null) {
                session.setAttribute("msg","Register Successfully");
                System.out.println("Register Successfully");
            } else {
                session.setAttribute("msg","Something Wrong on Server");
                System.out.println("Something Wrong on Server");
            }

        }
        return "redirect:/register";
    }


}