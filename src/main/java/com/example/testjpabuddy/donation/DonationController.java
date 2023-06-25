package com.example.testjpabuddy.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DonationController {

    DonationService donationService;

    @GetMapping("/donations")
    public List<Donation> getAllDonations() {
        return donationService.getAllDonations();
    }

    @GetMapping("/donations/{id}")
    public Donation getDonationById(@PathVariable Long id) {
        return donationService.getDonationById(id);
    }

    @Autowired

    public void setDonationService(DonationService donationService) {
        this.donationService = donationService;
    }
}
