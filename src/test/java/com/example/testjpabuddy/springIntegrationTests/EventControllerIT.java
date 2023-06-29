package com.example.testjpabuddy.springIntegrationTests;

import com.example.testjpabuddy.agency.Agency;
import com.example.testjpabuddy.donationItem.DonationItemController;
import com.example.testjpabuddy.donationItem.DonationItemServiceImpl;
import com.example.testjpabuddy.event.Event;
import com.example.testjpabuddy.event.EventController;
import com.example.testjpabuddy.event.EventServiceImpl;
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

@WebMvcTest(EventController.class)
@AutoConfigureMockMvc
public class EventControllerIT {

    @MockBean
    EventServiceImpl eventService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getAllEvents() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/events")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(eventService, times(1)).getAllEvents();
    }
    @Test
    public void getAllEventsReturns() throws Exception {

        List<Event> dummyList = Arrays.asList(new Event(), new Event());

        when(eventService.getAllEvents()).thenReturn(dummyList);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/events")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<Event> actualResponse = mapper.readValue(contentAsString, List.class);

        assertEquals(actualResponse.size(), dummyList.size());
    }

}
