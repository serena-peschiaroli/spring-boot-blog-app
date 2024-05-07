package com.serpes.springbootblogapp.services;

import com.serpes.springbootblogapp.models.Account;
import com.serpes.springbootblogapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account){
        return accountRepository.save(account);
    }
}