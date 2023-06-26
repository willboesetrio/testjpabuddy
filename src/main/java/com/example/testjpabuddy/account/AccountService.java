package com.example.testjpabuddy.account;

import java.util.List;

public interface AccountService {

    public List<Account> getAllAccounts();

    Account getAccountById(Long id);

     Account postLogin(LoginDto loginDto);

    void registerNewUser(RegisterDto registerDto);
}
