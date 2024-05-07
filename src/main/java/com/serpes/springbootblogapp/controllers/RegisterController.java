package com.serpes.springbootblogapp.controllers;

import com.serpes.springbootblogapp.models.Account;
import com.serpes.springbootblogapp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    //auto-ijections
    @Autowired
    private AccountService accountService;

    //handles http get request
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    //TODO: implement validation on registration form
    //handle http post request using modelattribute
    //bind incoming data to Account object
    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute Account account){
        //persistence in database
        accountService.save(account);

        /* TODO: feedback to user
        *   add parameter to display messages after redirect
        * */

        //redirect user to homepage and prevents duplicate submissions
        return "redirect:/";


    }
}
