package com.example.testjpabuddy.unitTests;

import com.example.testjpabuddy.account.AccountController;
import com.example.testjpabuddy.account.AccountServiceImpl;
import com.example.testjpabuddy.accountType.AccountTypeController;
import com.example.testjpabuddy.accountType.AccountTypeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AccountTypeUT {

    AccountTypeController uut;
    AccountTypeServiceImpl accountTypeService;

    @BeforeEach
    public void setUp() {
        uut = new AccountTypeController();
        accountTypeService = mock(AccountTypeServiceImpl.class);
        uut.setAccountTypeService(accountTypeService);
    }

    @Test
    public void CallServiceGetById() {
        String validAccountId = "V";
        uut.getAccountTypeById(validAccountId);
        verify(accountTypeService, times(1)).getAccountTypeById(validAccountId);
    }
}
