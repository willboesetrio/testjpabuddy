package com.example.testjpabuddy.springIntegrationTests;

import com.example.testjpabuddy.event.Event;
import com.example.testjpabuddy.event.EventController;
import com.example.testjpabuddy.event.EventDto;
import com.example.testjpabuddy.event.EventServiceImpl;
import com.example.testjpabuddy.eventAgencyJob.EAJDto;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJob;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJobController;
import com.example.testjpabuddy.eventAgencyJob.EventAgencyJobServiceImpl;
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

@WebMvcTest(EventAgencyJobController.class)
@AutoConfigureMockMvc
public class EventAgencyJobIT {

    @MockBean
    EventAgencyJobServiceImpl eventAgencyJobService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getAllEAJs() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/event-agency-jobs")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(eventAgencyJobService, times(1)).getAllEventAgencyJobs();
    }
    @Test
    public void getAllEventsReturns() throws Exception {

        List<EventAgencyJob> dummyList = Arrays.asList(new EventAgencyJob(), new EventAgencyJob());

        when(eventAgencyJobService.getAllEventAgencyJobs()).thenReturn(dummyList);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/event-agency-jobs")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<EventAgencyJob> actualResponse = mapper.readValue(contentAsString, List.class);

        assertEquals(actualResponse.size(), dummyList.size());
    }

    @Test
    public void postEAJ() throws Exception {
        EAJDto dummyDto = new EAJDto();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyDto);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/event-agency-jobs")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(eventAgencyJobService, times(1)).postEventAgencyJob(any());
    }

    @Test
    public void postEAJReturns() throws Exception {
        EAJDto dummyDto = new EAJDto();
        String dummyName = "DummyName";
        dummyDto.setName(dummyName);
        EventAgencyJob dummyEvent = new EventAgencyJob();
        dummyEvent.setName(dummyName);


        when(eventAgencyJobService.postEventAgencyJob(any())).thenReturn(dummyEvent);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyDto);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/event-agency-jobs")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        EventAgencyJob actualResponse = mapper.readValue(contentAsString, EventAgencyJob.class);

        assertEquals(actualResponse.getName(), dummyName);
    }


}
