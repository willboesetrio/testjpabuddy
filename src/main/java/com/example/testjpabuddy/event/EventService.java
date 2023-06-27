package com.example.testjpabuddy.event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();

    Event getEventById(Long id);
}
