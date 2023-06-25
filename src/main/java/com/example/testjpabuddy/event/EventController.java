package com.example.testjpabuddy.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    EventService eventService;

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @Autowired

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
