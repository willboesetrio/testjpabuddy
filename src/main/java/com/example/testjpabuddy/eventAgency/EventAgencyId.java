package com.example.testjpabuddy.eventAgency;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EventAgencyId implements Serializable {
    private static final long serialVersionUID = -1682189784159588213L;
    @Column(name = "EVENT_ID", nullable = false)
    private Long eventId;

    @Column(name = "AGENCY_ID", nullable = false)
    private Long agencyId;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EventAgencyId entity = (EventAgencyId) o;
        return Objects.equals(this.eventId, entity.eventId) &&
                Objects.equals(this.agencyId, entity.agencyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, agencyId);
    }

}