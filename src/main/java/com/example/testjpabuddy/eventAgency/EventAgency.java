package com.example.testjpabuddy.eventAgency;

import com.example.testjpabuddy.agency.Agency;
import com.example.testjpabuddy.event.Event;

import javax.persistence.*;

@Entity
@Table(name = "EVENT_AGENCY", indexes = {
        @Index(name = "FK_EVENT_AGENCY_AGENCY_INDEX_4", columnList = "AGENCY_ID"),
        @Index(name = "FK_EVENT_AGENCY_EVENT_INDEX_4", columnList = "EVENT_ID")
})
public class EventAgency {
    @EmbeddedId
    private EventAgencyId id;

    @MapsId("eventId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EVENT_ID", nullable = false)
    private Event event;

    @MapsId("agencyId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AGENCY_ID", nullable = false)
    private Agency agency;

    public EventAgencyId getId() {
        return id;
    }

    public void setId(EventAgencyId id) {
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

}