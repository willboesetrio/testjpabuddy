package com.example.testjpabuddy.eventParticipant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventParticipantRepo extends JpaRepository<EventParticipant, Long> {
    List<EventParticipant> findByAccountId(Long accountId);
}
