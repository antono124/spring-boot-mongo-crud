package com.antogeo.springbootmongocrud.service;

import com.antogeo.springbootmongocrud.model.Account;

import java.util.Optional;

public interface AccountService {

    void saveAccount(Account account);

    Optional<Account> findById(String id);

    void deleteAccount(String id);

}
