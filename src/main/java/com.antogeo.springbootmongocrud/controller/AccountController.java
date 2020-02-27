package com.antogeo.springbootmongocrud.controller;

import com.antogeo.springbootmongocrud.model.Account;
import com.antogeo.springbootmongocrud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public void createAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable String id){
        Optional<Account> account = accountService.findById(id);
        return account.get();
    }

    @DeleteMapping("/account/{id}")
    public void deleteAccount(@PathVariable String id){
        accountService.deleteAccount(id);
    }


}
