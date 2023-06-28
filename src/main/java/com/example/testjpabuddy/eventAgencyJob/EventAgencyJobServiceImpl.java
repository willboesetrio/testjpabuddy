package com.example.testjpabuddy.eventAgencyJob;

import com.example.testjpabuddy.agency.AgencyRepo;
import com.example.testjpabuddy.event.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventAgencyJobServiceImpl implements EventAgencyJobService{

    EventAgencyJobRepo eventAgencyJobRepo;
    EventRepo eventRepo;
    AgencyRepo agencyRepo;
    @Override
    public List<EventAgencyJob> getAllEventAgencyJobs() {
        return eventAgencyJobRepo.findAll();
    }

    @Override
    public EventAgencyJob getEventAgencyJobById(Long id) {
        return eventAgencyJobRepo.getEventAgencyJobById(id);
    }

    @Override
    public EventAgencyJob postEventAgencyJob(EAJDto eajDto) {

        EventAgencyJob thisEAJ = new EventAgencyJob();
        thisEAJ.setAgency(agencyRepo.getAgencyById(eajDto.getAgencyId()));
        thisEAJ.setEvent(eventRepo.getEventById(eajDto.getEventId()));
        thisEAJ.setName(eajDto.getName());
        thisEAJ.setRequestedHours(eajDto.getRequestedHours());
        return eventAgencyJobRepo.save(thisEAJ);
    }

    @Autowired

    public void setEventAgencyJobRepo(EventAgencyJobRepo eventAgencyJobRepo) {
        this.eventAgencyJobRepo = eventAgencyJobRepo;
    }
    @Autowired
    public void setEventRepo(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }
    @Autowired
    public void setAgencyRepo(AgencyRepo agencyRepo) {
        this.agencyRepo = agencyRepo;
    }
}
