package com.example.testjpabuddy.account;

import java.util.List;

public interface AccountService {

    public List<Account> getAllAccounts();

    Account getAccountById(Long id);
}
