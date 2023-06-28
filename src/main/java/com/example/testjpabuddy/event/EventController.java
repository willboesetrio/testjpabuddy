package com.example.testjpabuddy.event;

import com.example.testjpabuddy.agency.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/event-agency-lookup")
    public List<Event> getEventsByAgencyId(@RequestParam Long id) {
        return eventService.getEventsByAgencyId(id);
    }

    @PostMapping("/events")
    public Event postNewEvent(@RequestBody EventDto eventDto) {
        return eventService.postNewEvent(eventDto);
    }

    @Autowired

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
