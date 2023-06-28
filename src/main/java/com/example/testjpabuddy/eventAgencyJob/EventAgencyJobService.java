package com.example.testjpabuddy.eventAgencyJob;

import java.util.List;

public interface EventAgencyJobService {
    public List<EventAgencyJob> getAllEventAgencyJobs();

    EventAgencyJob getEventAgencyJobById(Long id);

    EventAgencyJob postEventAgencyJob(EAJDto eajDto);
}
