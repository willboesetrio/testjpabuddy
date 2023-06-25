package com.example.testjpabuddy.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService{

    DonationRepo donationRepo;
    @Override
    public List<Donation> getAllDonations() {
        return donationRepo.findAll();
    }

    @Override
    public Donation getDonationById(Long id) {
        return donationRepo.findDonationById(id);
    }

    @Autowired

    public void setDonationRepo(DonationRepo donationRepo) {
        this.donationRepo = donationRepo;
    }
}
