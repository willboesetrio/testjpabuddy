package com.example.testjpabuddy.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService{

    AgencyRepo agencyRepo;
    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepo.findAll();
    }

    @Override
    public Agency getAgencyById(Long id) {
       return agencyRepo.getAgencyById(id);
    }

    @Autowired

    public void setAgencyRepo(AgencyRepo agencyRepo) {
        this.agencyRepo = agencyRepo;
    }
}
