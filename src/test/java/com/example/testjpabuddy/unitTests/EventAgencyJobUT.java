package com.example.testjpabuddy.unitTests;

import com.example.testjpabuddy.eventAgencyJob.EventAgencyJob;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJobController;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJobServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
public class EventAgencyJobUT {

    EventAgencyJobController uut;
    EventAgencyJobServiceImpl eventAgencyJobService;

    @BeforeEach
    public void setUp() {
        uut = new EventAgencyJobController();
        eventAgencyJobService = mock(EventAgencyJobServiceImpl.class);
        uut.setEventAgencyJobService(eventAgencyJobService);
    }

    @Test
    public void getAllEAJs() {
        uut.getAllEventAgencyJobs();
        verify(eventAgencyJobService, times(1)).getAllEventAgencyJobs();
    }

    @Test
    public void getEAJById() {
        Long dummyId = 1L;
        uut.getEventAgencyJobById(dummyId);
        verify(eventAgencyJobService, times(1)).getEventAgencyJobById(dummyId);
    }

    @Test
    public void postEAJ() {
        uut.postEventAgencyJob(any());
        verify(eventAgencyJobService, times(1)).postEventAgencyJob(any());
    }

}
