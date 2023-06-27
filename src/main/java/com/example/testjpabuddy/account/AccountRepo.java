package com.example.testjpabuddy.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    Account getAccountById(Long id);
    Account getAccountByLoginId(String loginId);
    Account findByLoginId(String loginId);
}
