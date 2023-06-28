package com.example.testjpabuddy.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @PostMapping("/agencies")
    public Agency postNewAgency(@RequestBody Agency agency) {
        return agencyService.postNewAgency(agency);
    }

    @Autowired

    public void setAgencyService(AgencyService agencyService) {
        this.agencyService = agencyService;
    }
}
