package com.example.testjpabuddy.unitTests;
import com.example.testjpabuddy.account.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AccountControllerUT {

    AccountController uut;
    AccountServiceImpl accountService;

    @BeforeEach
    public void setUp() {
        uut = new AccountController();
        accountService = mock(AccountServiceImpl.class);
        uut.setAccountService(accountService);
    }

    @Test
    public void CallServiceGetAll() {
        uut.getAllAccounts();
        verify(accountService, times(1)).getAllAccounts();
    }
    @Test
    public void CallServiceGetById() {
        Long validAccountId = 1L;
        uut.getAccountById(validAccountId);
        verify(accountService, times(1)).getAccountById(validAccountId);
    }
    @Test
    public void CallServicePostLogin() {
        LoginDto dummyDto = new LoginDto();
        uut.postLogin(dummyDto);
        verify(accountService, times(1)).postLogin(dummyDto);
    }
    @Test
    public void CallServiceRegister() {
        RegisterDto dummyDto = new RegisterDto();
        uut.registerNewUser(dummyDto);
        verify(accountService, times(1)).registerNewUser(dummyDto);
    }
    @Test
    public void CallServiceAddPoints() {
        AddPointsDto dummyDto = new AddPointsDto();
        uut.addPointsToUser(dummyDto);
        verify(accountService, times(1)).addPointsToUser(dummyDto);
    }
    @Test
    public void CallServiceUpdateAccount() {
        Account dummyDto = new Account();
        uut.updateAccount(dummyDto);
        verify(accountService, times(1)).updateAccount(dummyDto);
    }


}
