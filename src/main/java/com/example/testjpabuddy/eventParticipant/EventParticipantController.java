package com.example.testjpabuddy.eventParticipant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EventParticipantController {

    EventParticipantService eventParticipantService;

    @GetMapping("/event-participants")
    public List<EventParticipant> getAllEventParticipants(){
        return eventParticipantService.getAllEventParticipants();
    }

    @Autowired

    public void setEventParticipantService(EventParticipantService eventParticipantService) {
        this.eventParticipantService = eventParticipantService;
    }
}
