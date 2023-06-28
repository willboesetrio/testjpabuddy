package com.example.testjpabuddy.eventParticipant;

import com.example.testjpabuddy.donation.Donation;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/event-participants")
    public EventParticipant postEventParticipant(@RequestBody EventParticipantDto eventParticipantDto) {
        return eventParticipantService.postEventParticipant(eventParticipantDto);
    }

    @Autowired

    public void setEventParticipantService(EventParticipantService eventParticipantService) {
        this.eventParticipantService = eventParticipantService;
    }
}
