package com.example.testjpabuddy.eventParticipant;

import java.util.List;

public interface EventParticipantService {
     public List<EventParticipant> getAllEventParticipants();

     List<EventParticipant> getEventParticipantsByAccountId(Long accountId);
}
