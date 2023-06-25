package com.example.testjpabuddy.donation;

import java.util.List;

public interface DonationService {
    List<Donation> getAllDonations();

    Donation getDonationById(Long id);
}
