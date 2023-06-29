package com.example.testjpabuddy.account;

import com.example.testjpabuddy.accountType.AccountTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    AccountRepo accountRepo;
    AccountTypeRepo accountTypeRepo;
    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepo.getAccountById(id);
    }

    @Override
    public Account postLogin(LoginDto loginDto) {
        return accountRepo.getAccountByLoginId(loginDto.getLoginId());
    }

    @Override
    public Account registerNewUser(RegisterDto registerDto) {
        Account newAccount = new Account();

        newAccount.setLoginId(registerDto.getLoginId());
        newAccount.setFirstName(registerDto.getFirstName());
        newAccount.setLastName(registerDto.getLastName());
        newAccount.setEmail(registerDto.getEmail());
        newAccount.setAddress1(registerDto.getAddress1());
        newAccount.setCity(registerDto.getCity());
        newAccount.setSt(registerDto.getSt());
        newAccount.setZip(registerDto.getZip());
        newAccount.setIs18(true);
        newAccount.setPoints(0);
        newAccount.setLastLoginTimestamp(Instant.now());
        newAccount.setAccountType(accountTypeRepo.getAccountTypeById("V"));

        accountRepo.save(newAccount);

        return accountRepo.findByLoginId(registerDto.getLoginId());

    }

    @Override
    public Account addPointsToUser(AddPointsDto addPointsDto) {

        Account thisAccount = accountRepo.getAccountById(addPointsDto.getAccountId());
        Integer previousPoints = thisAccount.getPoints();
        thisAccount.setPoints(addPointsDto.getPoints() + previousPoints);

        return accountRepo.save(thisAccount);
    }

    @Autowired
    public void setAccountRepo(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    @Autowired

    public void setAccountTypeRepo(AccountTypeRepo accountTypeRepo) {
        this.accountTypeRepo = accountTypeRepo;
    }
}
