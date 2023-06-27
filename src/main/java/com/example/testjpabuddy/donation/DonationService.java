package com.example.testjpabuddy.donation;

import java.util.List;

public interface DonationService {
    List<Donation> getAllDonations();

    Donation getDonationById(Long id);

    List<Donation> getDonationsByAccountId(Long AccountId);

    void postDonation(DonationDto donationdto);
}
