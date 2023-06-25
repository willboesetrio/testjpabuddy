package com.example.testjpabuddy.donationItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationItemServiceImpl implements DonationItemService{

    DonationItemRepo donationItemRepo;
    @Override
    public List<DonationItem> getByDonationId(Long donationId) {
        return donationItemRepo.findByDonationId(donationId);
    }

    @Autowired

    public void setDonationItemRepo(DonationItemRepo donationItemRepo) {
        this.donationItemRepo = donationItemRepo;
    }
}
