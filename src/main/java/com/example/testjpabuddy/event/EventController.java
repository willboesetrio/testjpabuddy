package com.example.testjpabuddy.event;

import com.example.testjpabuddy.agency.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EventController {

    EventService eventService;

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable Long id){
        return eventService.getEventById(id);
    }

    @Autowired

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
