package com.example.testjpabuddy;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "ACCOUNT", indexes = {
        @Index(name = "FK_ACCOUNT_ACCOUNT_TYPE_INDEX_E", columnList = "ACCOUNT_TYPE_ID")
})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "LOGIN_ID", nullable = false, length = 40)
    private String loginId;

    @Column(name = "FIRST_NAME", nullable = false, length = 40)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 40)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, length = 60)
    private String email;

    @Column(name = "PHONE", length = 40)
    private String phone;

    @Column(name = "ADDRESS1", nullable = false, length = 100)
    private String address1;

    @Column(name = "ADDRESS2", length = 100)
    private String address2;

    @Column(name = "CITY", nullable = false, length = 30)
    private String city;

    @Column(name = "ST", nullable = false, length = 2)
    private String st;

    @Column(name = "ZIP", nullable = false, length = 10)
    private String zip;

    @Column(name = "IS_18", nullable = false)
    private Boolean is18 = false;

    @Column(name = "POINTS", nullable = false)
    private Integer points;

    @Column(name = "LAST_LOGIN_TIMESTAMP", nullable = false)
    private Instant lastLoginTimestamp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ACCOUNT_TYPE_ID", nullable = false)
    private AccountType accountType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Boolean getIs18() {
        return is18;
    }

    public void setIs18(Boolean is18) {
        this.is18 = is18;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Instant getLastLoginTimestamp() {
        return lastLoginTimestamp;
    }

    public void setLastLoginTimestamp(Instant lastLoginTimestamp) {
        this.lastLoginTimestamp = lastLoginTimestamp;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}