package com.example.testjpabuddy.eventParticipant;

public class EventParticipantDto {

    Long eventAgencyJobId;

    Long accountId;

    Integer hoursRegistered;

    public Long getEventAgencyJobId() {
        return eventAgencyJobId;
    }

    public void setEventAgencyJobId(Long eventAgencyJobId) {
        this.eventAgencyJobId = eventAgencyJobId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getHoursRegistered() {
        return hoursRegistered;
    }

    public void setHoursRegistered(Integer hoursRegistered) {
        this.hoursRegistered = hoursRegistered;
    }
}
