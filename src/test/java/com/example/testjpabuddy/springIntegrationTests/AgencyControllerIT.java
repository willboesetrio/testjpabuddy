package com.example.testjpabuddy.springIntegrationTests;

import com.example.testjpabuddy.account.Account;
import com.example.testjpabuddy.account.AccountController;
import com.example.testjpabuddy.account.AccountServiceImpl;
import com.example.testjpabuddy.account.LoginDto;
import com.example.testjpabuddy.agency.Agency;
import com.example.testjpabuddy.agency.AgencyController;
import com.example.testjpabuddy.agency.AgencyServiceImpl;
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

@WebMvcTest(AgencyController.class)
@AutoConfigureMockMvc
public class AgencyControllerIT {

    @MockBean
    AgencyServiceImpl agencyService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getAllAgencies() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/agencies")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(agencyService, times(1)).getAllAgencies();
    }
    @Test
    public void getAllAgenciesReturns() throws Exception {

        List<Agency> dummyList = Arrays.asList(new Agency(), new Agency());

        when(agencyService.getAllAgencies()).thenReturn(dummyList);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/agencies")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<Agency> actualResponse = mapper.readValue(contentAsString, List.class);

        assertEquals(actualResponse.size(), dummyList.size());
    }

    @Test
    public void getAgencyById() throws Exception {
        Long dummyId = 1l;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/agencies/" + dummyId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(agencyService, times(1)).getAgencyById(dummyId);
    }

    @Test
    public void getAgencyByIdReturns() throws Exception {

        Agency dummyAgency = new Agency();
        Long dummyId = 1L;
        String dummyName = "DummyName";
        dummyAgency.setName(dummyName);

        when(agencyService.getAgencyById(dummyId)).thenReturn(dummyAgency);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/agencies/" + dummyId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Agency actualResponse = mapper.readValue(contentAsString, Agency.class);

        assertEquals(actualResponse.getName(), dummyName);
    }

    @Test
    public void postAgency() throws Exception {
       Agency dummyAgency = new Agency();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyAgency);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/agencies")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(agencyService, times(1)).postNewAgency(any());
    }

    @Test
    public void postAgencyReturns() throws Exception {
        Agency dummyAgency = new Agency();
        String dummyName = "DummyName";
        dummyAgency.setName(dummyName);

        when(agencyService.postNewAgency(any())).thenReturn(dummyAgency);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyAgency);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/agencies")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Agency actualResponse = mapper.readValue(contentAsString, Agency.class);

        assertEquals(actualResponse.getName(), dummyName);
    }

}
