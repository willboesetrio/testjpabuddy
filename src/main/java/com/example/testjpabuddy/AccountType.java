package com.example.testjpabuddy;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TYPE")
public class AccountType {
    @Id
    @Column(name = "ID", nullable = false, length = 1)
    private String id;

    @Column(name = "NAME", nullable = false, length = 40)
    private String name;

    @OneToMany(mappedBy = "accountType")
    private Set<Account> accounts = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

}