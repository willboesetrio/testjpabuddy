package com.example.testjpabuddy.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AccountController {

    AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/login")
    public Account postLogin(@RequestBody LoginDto loginDto){
        return accountService.postLogin(loginDto);
    }

    @PostMapping("/register")
    public Account registerNewUser(@RequestBody RegisterDto registerDto) {
        return accountService.registerNewUser(registerDto);
    }


    @Autowired

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
