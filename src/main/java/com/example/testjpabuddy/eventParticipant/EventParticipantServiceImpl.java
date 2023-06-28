package com.example.testjpabuddy.eventParticipant;

import com.example.testjpabuddy.account.AccountRepo;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventParticipantServiceImpl implements EventParticipantService{

    EventParticipantRepo eventParticipantRepo;

    EventAgencyJobRepo eventAgencyJobRepo;

    AccountRepo accountRepo;

    @Override
    public List<EventParticipant> getAllEventParticipants() {
        return eventParticipantRepo.findAll();
    }

    @Override
    public List<EventParticipant> getEventParticipantsByAccountId(Long accountId) {
        return eventParticipantRepo.findByAccountId(accountId);
    }

    @Override
    public EventParticipant postEventParticipant(EventParticipantDto eventParticipantDto) {

        EventParticipant thisEventParticipant = new EventParticipant();
        thisEventParticipant.setEventAgencyJob(eventAgencyJobRepo.getEventAgencyJobById(eventParticipantDto.getEventAgencyJobId()));
        thisEventParticipant.setAccount(accountRepo.getAccountById(eventParticipantDto.getAccountId()));
        thisEventParticipant.setHoursRegistered(eventParticipantDto.getHoursRegistered());
        thisEventParticipant.setHoursCompleted(0);

        return eventParticipantRepo.save(thisEventParticipant);
    }

    @Autowired

    public void setEventParticipantRepo(EventParticipantRepo eventParticipantRepo) {
        this.eventParticipantRepo = eventParticipantRepo;
    }
    @Autowired
    public void setEventAgencyJobRepo(EventAgencyJobRepo eventAgencyJobRepo) {
        this.eventAgencyJobRepo = eventAgencyJobRepo;
    }
    @Autowired
    public void setAccountRepo(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
}
