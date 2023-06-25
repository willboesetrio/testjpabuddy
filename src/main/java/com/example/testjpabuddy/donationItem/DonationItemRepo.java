package com.example.testjpabuddy.donationItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationItemRepo extends JpaRepository<DonationItem, Long> {
    List<DonationItem> findByDonationId(Long donationId);
}
