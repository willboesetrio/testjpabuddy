package com.example.testjpabuddy.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("/user-donations")
    public List<Donation> getDonationsByAccountId(@RequestParam Long accountId) {
        return donationService.getDonationsByAccountId(accountId);
    }

    @PostMapping("/donate")
    public void postDonation(@RequestBody DonationDto donationDto) {
        donationService.postDonation(donationDto);
    }

    @Autowired

    public void setDonationService(DonationService donationService) {
        this.donationService = donationService;
    }
}
