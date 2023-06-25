package com.example.testjpabuddy.eventAgencyJob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventAgencyJobServiceImpl implements EventAgencyJobService{

    EventAgencyJobRepo eventAgencyJobRepo;
    @Override
    public List<EventAgencyJob> getAllEventAgencyJobs() {
        return eventAgencyJobRepo.findAll();
    }

    @Autowired

    public void setEventAgencyJobRepo(EventAgencyJobRepo eventAgencyJobRepo) {
        this.eventAgencyJobRepo = eventAgencyJobRepo;
    }
}
