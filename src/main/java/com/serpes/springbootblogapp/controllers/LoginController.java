package com.serpes.springbootblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView handleLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password){

        //validate credentials
        boolean isValidUser = checkCredentials(username, password);
        if(isValidUser){
            return new ModelAndView("redirect:/home");

        }else{
            //return to login page with error msn
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Invalid credentials");
            return modelAndView;
        }
    }

    private boolean checkCredentials(String username, String password){
        //TODO: implement authetication login logic

        return "user".equals(username) && "pass".equals(password);
    }

}
