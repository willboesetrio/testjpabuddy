package com.example.testjpabuddy.event;

import com.example.testjpabuddy.agency.AgencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    EventRepo eventRepo;

    AgencyRepo agencyRepo;
    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepo.getEventById(id);
    }

    @Override
    public Event postNewEvent(EventDto eventDto) {

        Event thisEvent = new Event();
        thisEvent.setName(eventDto.getName());
        thisEvent.setAddress1(eventDto.getAddress1());
        thisEvent.setAddress2(eventDto.getAddress2());
        thisEvent.setCity(eventDto.getCity());
        thisEvent.setSt(eventDto.getSt());
        thisEvent.setZip(eventDto.getZip());
        thisEvent.setEventDatetime(eventDto.getEventDatetime());
        thisEvent.setAgency(agencyRepo.getAgencyById(eventDto.getAgencyId()));

        return eventRepo.save(thisEvent);
    }

    @Override
    public List<Event> getEventsByAgencyId(Long id) {
        return eventRepo.getEventByAgencyId(id);
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
