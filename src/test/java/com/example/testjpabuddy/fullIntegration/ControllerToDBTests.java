package com.example.testjpabuddy.fullIntegration;

import com.example.testjpabuddy.TestjpabuddyApplication;
import com.example.testjpabuddy.account.Account;
import com.example.testjpabuddy.accountType.AccountType;
import com.example.testjpabuddy.agency.Agency;
import com.example.testjpabuddy.donation.Donation;
import com.example.testjpabuddy.event.Event;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJob;
import com.example.testjpabuddy.eventParticipant.EventParticipant;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TestjpabuddyApplication.class)
@AutoConfigureMockMvc
public class ControllerToDBTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void getAccountsHttpRequest() throws Exception {
        int numberOfAccountsInDB = 5;

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/accounts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<Account> actualResult = mapper.readValue(contentAsString, List.class);

        assertTrue(actualResult.size() >= numberOfAccountsInDB);
    }
    @Test
    public void getAgenciesHttpRequest() throws Exception {
        int numberOfAgenciesInDB = 5;

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/agencies")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<Agency> actualResult = mapper.readValue(contentAsString, List.class);

        assertTrue(actualResult.size() >= numberOfAgenciesInDB);
    }

    @Test
    public void getDonationsHttpRequest() throws Exception {
        int numberOfDonosInDB = 5;

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/donations")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<Donation> actualResult = mapper.readValue(contentAsString, List.class);

        assertTrue(actualResult.size() >= numberOfDonosInDB);
    }

    @Test
    public void getEventsHttpRequest() throws Exception {
        int numberOfEventsInDB = 5;

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/events")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<Event> actualResult = mapper.readValue(contentAsString, List.class);

        assertTrue(actualResult.size() >= numberOfEventsInDB);
    }
    @Test
    public void getEAJsHttpRequest() throws Exception {
        int numberOfEAjsInDB = 5;

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/event-agency-jobs")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<EventAgencyJob> actualResult = mapper.readValue(contentAsString, List.class);

        assertTrue(actualResult.size() >= numberOfEAjsInDB);
    }
    @Test
    public void getEPsHttpRequest() throws Exception {
        int numberOfEPsInDB = 4;

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/event-participants")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<EventParticipant> actualResult = mapper.readValue(contentAsString, List.class);

        assertTrue(actualResult.size() >= numberOfEPsInDB);
    }
}
