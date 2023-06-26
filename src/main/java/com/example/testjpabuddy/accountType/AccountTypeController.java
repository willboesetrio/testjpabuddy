package com.example.testjpabuddy.accountType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountTypeController {

    AccountTypeService accountTypeService;

    @GetMapping("/account-type/{id}")
    public AccountType getAccountTypeById(@PathVariable String id){
        return accountTypeService.getAccountTypeById(id);
    }

    @Autowired

    public void setAccountTypeService(AccountTypeService accountTypeService) {
        this.accountTypeService = accountTypeService;
    }
}
