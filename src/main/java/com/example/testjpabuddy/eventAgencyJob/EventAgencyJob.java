package com.example.testjpabuddy.eventAgencyJob;

import com.example.testjpabuddy.agency.Agency;
import com.example.testjpabuddy.event.Event;

import javax.persistence.*;

@Entity
@Table(name = "EVENT_AGENCY_JOB", indexes = {
        @Index(name = "FK_EVENT_AGENCY_JOB_EVENT_INDEX_A", columnList = "EVENT_ID"),
        @Index(name = "FK_EVENT_AGENCY_JOB_AGENCY_INDEX_A", columnList = "AGENCY_ID")
})
public class EventAgencyJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EVENT_ID", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AGENCY_ID", nullable = false)
    private Agency agency;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "REQUESTED_HOURS", nullable = false)
    private Integer requestedHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRequestedHours() {
        return requestedHours;
    }

    public void setRequestedHours(Integer requestedHours) {
        this.requestedHours = requestedHours;
    }

}