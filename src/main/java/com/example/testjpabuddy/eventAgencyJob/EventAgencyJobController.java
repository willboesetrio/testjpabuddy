package com.example.testjpabuddy.eventAgencyJob;

import com.example.testjpabuddy.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EventAgencyJobController {

    EventAgencyJobService eventAgencyJobService;

    @GetMapping("/event-agency-jobs")
    public List<EventAgencyJob> getAllEventAgencyJobs() {
        return eventAgencyJobService.getAllEventAgencyJobs();
    }

    @GetMapping("/event-agency-jobs/{id}")
    public EventAgencyJob getEventAgencyJobById(@PathVariable Long id){
        return eventAgencyJobService.getEventAgencyJobById(id);
    }

    @Autowired

    public void setEventAgencyJobService(EventAgencyJobService eventAgencyJobService) {
        this.eventAgencyJobService = eventAgencyJobService;
    }
}
