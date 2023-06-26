package com.example.testjpabuddy.accountType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType, String> {
    AccountType getAccountTypeById(String id);

}
