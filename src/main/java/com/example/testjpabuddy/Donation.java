package com.example.testjpabuddy;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "DONATION", indexes = {
        @Index(name = "FK_DONATION_AGENCY_INDEX_7", columnList = "AGENCY_ID"),
        @Index(name = "FK_DONATION_ACCOUNT_INDEX_7", columnList = "ACCOUNT_ID")
})
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AGENCY_ID", nullable = false)
    private Agency agency;

    @Column(name = "DONATION_DATETIME", nullable = false)
    private Instant donationDatetime;

    @Column(name = "EVENT_ID")
    private Long eventId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Instant getDonationDatetime() {
        return donationDatetime;
    }

    public void setDonationDatetime(Instant donationDatetime) {
        this.donationDatetime = donationDatetime;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

}