package com.leasing.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SecurityController {

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/bye")
    public String getByePage(Principal principal){
        System.out.println(principal);
        return "bye";
    }
    @GetMapping("/hello")
    public String getHelloPage(){
        return "hello";
    }

    @GetMapping
    public String getHomeAlsoPage(){
        return "home";
    }
}
