package com.example.testjpabuddy.unitTests;

import com.example.testjpabuddy.agency.Agency;
import com.example.testjpabuddy.agency.AgencyController;
import com.example.testjpabuddy.agency.AgencyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AgencyControllerUT {

    AgencyController uut;
    AgencyServiceImpl agencyService;

    @BeforeEach
    public void setUp() {
        uut = new AgencyController();
        agencyService = mock(AgencyServiceImpl.class);
        uut.setAgencyService(agencyService);
    }
    @Test
    public void CallServiceGetAll() {
        uut.getAllAgencies();
        verify(agencyService, times(1)).getAllAgencies();
    }
    @Test
    public void CallServiceGetById() {
        Long validAccountId = 1L;
        uut.getAgencyById(validAccountId);
        verify(agencyService, times(1)).getAgencyById(validAccountId);
    }

    @Test
    public void CallPostAgency() {
        uut.postNewAgency(new Agency());
        verify(agencyService, times(1)).postNewAgency(any());
    }

}
