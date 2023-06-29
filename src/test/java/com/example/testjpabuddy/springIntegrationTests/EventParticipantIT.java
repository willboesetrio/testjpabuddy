package com.example.testjpabuddy.springIntegrationTests;
import com.example.testjpabuddy.eventAgencyJob.EAJDto;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJob;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJobController;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJobServiceImpl;
import com.example.testjpabuddy.eventParticipant.EventParticipant;
import com.example.testjpabuddy.eventParticipant.EventParticipantController;
import com.example.testjpabuddy.eventParticipant.EventParticipantDto;
import com.example.testjpabuddy.eventParticipant.EventParticipantServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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

@WebMvcTest(EventParticipantController.class)
@AutoConfigureMockMvc
public class EventParticipantIT {

    @MockBean
    EventParticipantServiceImpl eventParticipantService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getAllEPs() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/event-participants")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(eventParticipantService, times(1)).getAllEventParticipants();
    }
    @Test
    public void getAllEventsReturns() throws Exception {

        List<EventParticipant> dummyList = Arrays.asList(new EventParticipant(), new EventParticipant());

        when(eventParticipantService.getAllEventParticipants()).thenReturn(dummyList);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/event-participants")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<EventParticipant> actualResponse = mapper.readValue(contentAsString, List.class);

        assertEquals(actualResponse.size(), dummyList.size());
    }

    @Test
    public void postEP() throws Exception {
        EventParticipantDto dummyDto = new EventParticipantDto();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyDto);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/event-participants")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(eventParticipantService, times(1)).postEventParticipant(any());
    }

    @Test
    public void postEPReturns() throws Exception {
        EventParticipantDto dummyDto = new EventParticipantDto();
        Long dummyId = 1L;
        EventParticipant dummyEP = new EventParticipant();
        dummyEP.setId(dummyId);


        when(eventParticipantService.postEventParticipant(any())).thenReturn(dummyEP);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyDto);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/event-participants")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        EventParticipant actualResponse = mapper.readValue(contentAsString, EventParticipant.class);

        assertEquals(actualResponse.getId(), dummyId);
    }

}
