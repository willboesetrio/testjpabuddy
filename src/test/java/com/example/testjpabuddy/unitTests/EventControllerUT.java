package com.example.testjpabuddy.unitTests;

import com.example.testjpabuddy.event.Event;
import com.example.testjpabuddy.event.EventController;
import com.example.testjpabuddy.event.EventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
public class EventControllerUT {

    EventController uut;
    EventServiceImpl eventService;

    @BeforeEach
    public void setUp() {
        uut = new EventController();
        eventService = mock(EventServiceImpl.class);
        uut.setEventService(eventService);
    }

    @Test
    public void getAllEvents() {
        uut.getAllEvents();
        verify(eventService, times(1)).getAllEvents();
    }

    @Test
    public void getEventById() {
        Long dummyId = 1L;
        uut.getEventById(dummyId);
        verify(eventService,times(1)).getEventById(dummyId);
    }

    @Test
    public void getByAgencyId() {
        Long dummyId = 1L;
        uut.getEventsByAgencyId(dummyId);
        verify(eventService,times(1)).getEventsByAgencyId(dummyId);
    }
    @Test
    public void postEvent() {
        uut.postNewEvent(any());
        verify(eventService, times(1)).postNewEvent(any());
    }

}
