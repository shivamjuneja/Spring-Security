package com.example.springsecuritybasics.controller;


import com.example.springsecuritybasics.model.Accounts;
import com.example.springsecuritybasics.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

//    @GetMapping("/myAccount")
//    public String getAccountDetails() {
//        return "Here are the account details from the DB";
//    }

    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) {
//        System.out.println("before the account repo cll"+ id );
        Accounts accounts = accountsRepository.findByCustomerId(id);
        System.out.println(accounts.getCustomerId()+"-----"+accounts.getAccountType());
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }

}
