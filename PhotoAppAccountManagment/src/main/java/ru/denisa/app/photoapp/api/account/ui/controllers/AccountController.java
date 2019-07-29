package ru.denisa.app.photoapp.api.account.ui.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {


    @GetMapping("/status/check")
    public String check(){
        return "working";
    }


}
