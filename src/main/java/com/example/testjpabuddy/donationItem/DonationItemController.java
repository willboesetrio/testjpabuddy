package com.example.testjpabuddy.donationItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DonationItemController {

    DonationItemService donationItemService;
    @GetMapping("/donation-items/{donationId}")
    public List<DonationItem> GetByDonationId(@PathVariable Long donationId){
        return donationItemService.getByDonationId(donationId);
    }

    @Autowired

    public void setDonationItemService(DonationItemService donationItemService) {
        this.donationItemService = donationItemService;
    }
}
