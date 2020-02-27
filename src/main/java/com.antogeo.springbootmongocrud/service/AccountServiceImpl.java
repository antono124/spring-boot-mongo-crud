package com.antogeo.springbootmongocrud.service;

import com.antogeo.springbootmongocrud.model.Account;
import com.antogeo.springbootmongocrud.model.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository repository;

    AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAccount(Account account) {
        repository.save(account);
    }

    @Override
    public Optional<Account> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void deleteAccount(String id) {
        Optional<Account> account = findById(id);
        account.ifPresent(account1 -> repository.delete(account1));
    }
}
