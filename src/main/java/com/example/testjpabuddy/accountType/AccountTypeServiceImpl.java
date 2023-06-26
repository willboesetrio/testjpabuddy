package com.example.testjpabuddy.accountType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeServiceImpl implements AccountTypeService{

    AccountTypeRepo accountTypeRepo;
    @Override
    public AccountType getAccountTypeById(String id) {
        return accountTypeRepo.getAccountTypeById(id);
    }

    @Autowired

    public void setAccountTypeRepo(AccountTypeRepo accountTypeRepo) {
        this.accountTypeRepo = accountTypeRepo;
    }
}
