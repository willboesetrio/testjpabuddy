package com.example.testjpabuddy.unitTests;

import com.example.testjpabuddy.donation.DonationController;
import com.example.testjpabuddy.donation.DonationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class DonationControllerUT {

    DonationController uut;
    DonationServiceImpl donationService;

    @BeforeEach
    public void setUp() {
        uut = new DonationController();
        donationService = mock(DonationServiceImpl.class);
        uut.setDonationService(donationService);
    }

    @Test
    public void callServiceGetAll() {
        uut.getAllDonations();
        verify(donationService, times(1)).getAllDonations();
    }
    @Test
    public void callServiceById() {
        Long dummyId = 1L;
        uut.getDonationById(dummyId);
        verify(donationService, times(1)).getDonationById(dummyId);
    }
    @Test
    public void callServiceByAccountId() {
        Long dummyId = 1L;
        uut.getDonationsByAccountId(dummyId);
        verify(donationService, times(1)).getDonationsByAccountId(dummyId);
    }
    @Test
    public void callServicePost() {
        uut.postDonation(any());
        verify(donationService, times(1)).postDonation(any());
    }
}
