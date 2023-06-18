package com.example.testjpabuddy;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AgencyFocusId implements Serializable {
    private static final long serialVersionUID = 3039773140665078991L;
    @Column(name = "AGENCY_ID", nullable = false)
    private Long agencyId;

    @Column(name = "FOCUS_ID", nullable = false)
    private Long focusId;

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    public Long getFocusId() {
        return focusId;
    }

    public void setFocusId(Long focusId) {
        this.focusId = focusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AgencyFocusId entity = (AgencyFocusId) o;
        return Objects.equals(this.agencyId, entity.agencyId) &&
                Objects.equals(this.focusId, entity.focusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencyId, focusId);
    }

}