package com.example.testjpabuddy.springIntegrationTests;
import com.example.testjpabuddy.donation.Donation;
import com.example.testjpabuddy.donation.DonationController;
import com.example.testjpabuddy.donation.DonationServiceImpl;
import com.example.testjpabuddy.donationItem.DonationItem;
import com.example.testjpabuddy.donationItem.DonationItemController;
import com.example.testjpabuddy.donationItem.DonationItemServiceImpl;
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

@WebMvcTest(DonationItemController.class)
@AutoConfigureMockMvc
public class DonationItemIT {

    @MockBean
    DonationItemServiceImpl donationItemService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getByDonationId() throws Exception {
        Long dummyId = 1l;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/donation-items/" + dummyId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(donationItemService, times(1)).getByDonationId(dummyId);
    }

    @Test
    public void geByDonationIdReturns() throws Exception {

        List<DonationItem> dummyList = Arrays.asList(new DonationItem(), new DonationItem());
        Long dummyId = 1L;

        when(donationItemService.getByDonationId(dummyId)).thenReturn(dummyList);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/donation-items/" + dummyId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<DonationItem> actualResponse = mapper.readValue(contentAsString, List.class);

        assertEquals(actualResponse.size(), dummyList.size());
    }

}
