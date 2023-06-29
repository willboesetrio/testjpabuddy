package com.example.testjpabuddy.account;

import java.util.List;

public interface AccountService {

    public List<Account> getAllAccounts();

    Account getAccountById(Long id);

     Account postLogin(LoginDto loginDto);

    Account registerNewUser(RegisterDto registerDto);

    Account addPointsToUser(AddPointsDto addPointsDto);
}
