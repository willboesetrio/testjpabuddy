package com.example.testjpabuddy.event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();

    Event getEventById(Long id);

    Event postNewEvent(EventDto eventDto);

    List<Event> getEventsByAgencyId(Long id);
}
