package com.example.testjpabuddy.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    AccountRepo accountRepo;
    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepo.getAccountById(id);
    }

    @Autowired
    public void setAccountRepo(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
}
