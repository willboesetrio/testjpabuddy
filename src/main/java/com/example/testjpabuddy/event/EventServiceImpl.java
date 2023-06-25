package com.example.testjpabuddy.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    EventRepo eventRepo;
    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @Autowired

    public void setEventRepo(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }
}
