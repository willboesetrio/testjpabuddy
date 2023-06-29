package com.example.testjpabuddy.springIntegrationTests;

import com.example.testjpabuddy.agency.Agency;
import com.example.testjpabuddy.donation.Donation;
import com.example.testjpabuddy.donation.DonationController;
import com.example.testjpabuddy.donation.DonationServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@WebMvcTest(DonationController.class)
@AutoConfigureMockMvc
public class DonationControllerIT {

    @MockBean
    DonationServiceImpl donationService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getAllDonations() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/donations")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(donationService, times(1)).getAllDonations();
    }
    @Test
    public void getAllAgenciesReturns() throws Exception {

        List<Donation> dummyList = Arrays.asList(new Donation(), new Donation());

        when(donationService.getAllDonations()).thenReturn(dummyList);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/donations")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<Donation> actualResponse = mapper.readValue(contentAsString, List.class);

        assertEquals(actualResponse.size(), dummyList.size());
    }

    @Test
    public void getDonationById() throws Exception {
        Long dummyId = 1l;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/donations/" + dummyId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(donationService, times(1)).getDonationById(dummyId);
    }

    @Test
    public void getDonationByIdReturns() throws Exception {

        Donation dummyDonation = new Donation();
        Long dummyId = 1L;
        dummyDonation.setId(dummyId);

        when(donationService.getDonationById(dummyId)).thenReturn(dummyDonation);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/donations/" + dummyId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Donation actualResponse = mapper.readValue(contentAsString, Donation.class);

        assertEquals(actualResponse.getId(), dummyId);
    }
    @Test
    public void getDonationsByAccountId() throws Exception {
        Long dummyId = 1l;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/user-donations?accountId=" + dummyId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(donationService, times(1)).getDonationsByAccountId(dummyId);
    }

    @Test
    public void getDonationsByAccountIdReturns() throws Exception {

        List<Donation> dummyList = Arrays.asList(new Donation(), new Donation());
        Long dummyId = 1L;

        when(donationService.getDonationsByAccountId(dummyId)).thenReturn(dummyList);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/user-donations?accountId=" + dummyId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<Donation> actualResponse = mapper.readValue(contentAsString, List.class);

        assertEquals(actualResponse.size(), dummyList.size());
    }
}
