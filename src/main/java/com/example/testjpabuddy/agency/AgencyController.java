package com.example.testjpabuddy.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgencyController {

    AgencyService agencyService;

    @GetMapping("/agencies")
    public List<Agency> getAllAgencies() {
        return agencyService.getAllAgencies();
    }

    @GetMapping("/agencies/{id}")
    public Agency getAgencyById(@PathVariable Long id){
        return agencyService.getAgencyById(id);
    }

    @Autowired

    public void setAgencyService(AgencyService agencyService) {
        this.agencyService = agencyService;
    }
}
