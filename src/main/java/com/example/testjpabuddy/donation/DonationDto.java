package com.example.testjpabuddy.donation;

import java.math.BigDecimal;

public class DonationDto {

    private BigDecimal dollarValue;

    private String desc;

    private Long accountId;

    private Long agencyId;

    public BigDecimal getDollarValue() {
        return dollarValue;
    }

    public void setDollarValue(BigDecimal dollarValue) {
        this.dollarValue = dollarValue;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }
}
