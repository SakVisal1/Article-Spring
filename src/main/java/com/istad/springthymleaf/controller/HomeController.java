package com.istad.springthymleaf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    @GetMapping("/index")
    public ModelAndView getHomePage(){
        ModelAndView obj = new ModelAndView();
        obj.setViewName("index");

        return obj ;
    }
    @GetMapping("/registration")
    public String registerForm() {
        return "register-form";
    }
}
