package com.example.testjpabuddy.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepo extends JpaRepository<Donation, Long> {
    Donation findDonationById(Long id);

    List<Donation> findByAccountId(Long accountId);
}
