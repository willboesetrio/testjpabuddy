package com.example.testjpabuddy.eventParticipant;

import com.example.testjpabuddy.donation.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/user-event-participants")
    public List<EventParticipant> getEventParticipantsByAccountId(@RequestParam Long accountId) {
        return eventParticipantService.getEventParticipantsByAccountId(accountId);
    }

    @Autowired

    public void setEventParticipantService(EventParticipantService eventParticipantService) {
        this.eventParticipantService = eventParticipantService;
    }
}
