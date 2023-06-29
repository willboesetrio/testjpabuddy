package com.example.testjpabuddy.unitTests;

import com.example.testjpabuddy.eventParticipant.EventParticipantController;
import com.example.testjpabuddy.eventParticipant.EventParticipantServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
public class EventParticipantUT {

    EventParticipantController uut;
    EventParticipantServiceImpl eventParticipantService;

    @BeforeEach
    public void setUp() {
        uut = new EventParticipantController();
        eventParticipantService = mock(EventParticipantServiceImpl.class);
        uut.setEventParticipantService(eventParticipantService);
    }

    @Test
    public void getAllEPs() {
        uut.getAllEventParticipants();
        verify(eventParticipantService, times(1)).getAllEventParticipants();
    }

    @Test
    public void getEPbyAccountId() {
        Long dummyId = 1L;
        uut.getEventParticipantsByAccountId(dummyId);
        verify(eventParticipantService, times(1)).getEventParticipantsByAccountId(dummyId);
    }

    @Test
    public void postEP() {
        uut.postEventParticipant(any());
        verify(eventParticipantService, times(1)).postEventParticipant(any());
    }
}
