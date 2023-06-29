//package com.example.testjpabuddy.agencyFocus;
//
//import com.example.testjpabuddy.focus.Focus;
//import com.example.testjpabuddy.agency.Agency;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "AGENCY_FOCUS", indexes = {
//        @Index(name = "FK_AGENCY_FOCUS_AGENCY_INDEX_7", columnList = "AGENCY_ID"),
//        @Index(name = "FK_AGENCY_FOCUS_FOCUS_INDEX_7", columnList = "FOCUS_ID")
//})
//public class AgencyFocus {
//    @EmbeddedId
//    private AgencyFocusId id;
//
//    @MapsId("agencyId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "AGENCY_ID", nullable = false)
//    private Agency agency;
//
//    @MapsId("focusId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "FOCUS_ID", nullable = false)
//    private Focus focus;
//
//    public AgencyFocusId getId() {
//        return id;
//    }
//
//    public void setId(AgencyFocusId id) {
//        this.id = id;
//    }
//
//    public Agency getAgency() {
//        return agency;
//    }
//
//    public void setAgency(Agency agency) {
//        this.agency = agency;
//    }
//
//    public Focus getFocus() {
//        return focus;
//    }
//
//    public void setFocus(Focus focus) {
//        this.focus = focus;
//    }
//
//}