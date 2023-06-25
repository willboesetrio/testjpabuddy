package com.example.testjpabuddy.eventParticipant;

import com.example.testjpabuddy.account.Account;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJob;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "EVENT_PARTICIPANT", indexes = {
        @Index(name = "FK_EVENT_PARTICIPANT_EVENT_AGENCY_JOB_INDEX_5", columnList = "EVENT_AGENCY_JOB_ID"),
        @Index(name = "FK_EVENT_PARTICIPANT_ACCOUNT_INDEX_5", columnList = "ACCOUNT_ID")
})
public class EventParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EVENT_AGENCY_JOB_ID", nullable = false)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("event_agency_job_id")
    private EventAgencyJob eventAgencyJob;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("account_id")
    private Account account;

    @Column(name = "HOURS_REGISTERED", nullable = false)
    private Integer hoursRegistered;

    @Column(name = "HOURS_COMPLETED")
    private Integer hoursCompleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventAgencyJob getEventAgencyJob() {
        return eventAgencyJob;
    }

    public void setEventAgencyJob(EventAgencyJob eventAgencyJob) {
        this.eventAgencyJob = eventAgencyJob;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getHoursRegistered() {
        return hoursRegistered;
    }

    public void setHoursRegistered(Integer hoursRegistered) {
        this.hoursRegistered = hoursRegistered;
    }

    public Integer getHoursCompleted() {
        return hoursCompleted;
    }

    public void setHoursCompleted(Integer hoursCompleted) {
        this.hoursCompleted = hoursCompleted;
    }

}