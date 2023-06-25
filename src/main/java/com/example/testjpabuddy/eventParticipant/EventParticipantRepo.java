package com.example.testjpabuddy.eventParticipant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventParticipantRepo extends JpaRepository<EventParticipant, Long> {
}
