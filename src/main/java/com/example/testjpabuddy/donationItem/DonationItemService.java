package com.example.testjpabuddy.donationItem;

import java.util.List;

public interface DonationItemService {
    List<DonationItem> getByDonationId(Long donationId);
}
