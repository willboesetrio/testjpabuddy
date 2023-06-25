package com.example.testjpabuddy.eventParticipant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventParticipantServiceImpl implements EventParticipantService{

    EventParticipantRepo eventParticipantRepo;

    @Override
    public List<EventParticipant> getAllEventParticipants() {
        return eventParticipantRepo.findAll();
    }

    @Autowired

    public void setEventParticipantRepo(EventParticipantRepo eventParticipantRepo) {
        this.eventParticipantRepo = eventParticipantRepo;
    }
}
