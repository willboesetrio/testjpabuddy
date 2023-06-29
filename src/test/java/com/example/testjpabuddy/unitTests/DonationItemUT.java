package com.example.testjpabuddy.unitTests;

import com.example.testjpabuddy.donationItem.DonationItemController;
import com.example.testjpabuddy.donationItem.DonationItemService;
import com.example.testjpabuddy.donationItem.DonationItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
public class DonationItemUT {

    DonationItemController uut;
    DonationItemServiceImpl donationItemService;

    @BeforeEach
    public void setUp() {
        uut = new DonationItemController();
        donationItemService = mock(DonationItemServiceImpl.class);
        uut.setDonationItemService(donationItemService);
    }

    @Test
    public void getByDonationId() {
        Long dummyId = 1L;
        uut.GetByDonationId(dummyId);
        verify(donationItemService, times(1)).getByDonationId(dummyId);
    }
}
