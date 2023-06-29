package com.example.testjpabuddy.springIntegrationTests;

import com.example.testjpabuddy.account.*;
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

@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
public class AccountControllerIT {

    @MockBean
    AccountServiceImpl accountService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getAllAccounts() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/accounts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(accountService, times(1)).getAllAccounts();
    }
    @Test
    public void getAllAccountsReturns() throws Exception {

        List<Account> dummyList = Arrays.asList(new Account(), new Account());

        when(accountService.getAllAccounts()).thenReturn(dummyList);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/accounts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<Account> actualResponse = mapper.readValue(contentAsString, List.class);

        assertEquals(actualResponse.size(), dummyList.size());
    }

    @Test
    public void getAccountById() throws Exception {
        Long dummyId = 1l;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/accounts/" + dummyId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(accountService, times(1)).getAccountById(dummyId);
    }

    @Test
    public void getAccountByIdReturns() throws Exception {

        Account dummyAcc = new Account();
        Long dummyId = 1L;
        String dummyLoginId = "DummyId";
        dummyAcc.setLoginId(dummyLoginId);

        when(accountService.getAccountById(dummyId)).thenReturn(dummyAcc);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/accounts/" + dummyId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Account actualResponse = mapper.readValue(contentAsString, Account.class);

        assertEquals(actualResponse.getLoginId(), dummyLoginId);
    }

    @Test
    public void postLogin() throws Exception {
        LoginDto dummyDto = new LoginDto();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyDto);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(accountService, times(1)).postLogin(any());
    }

    @Test
    public void postLoginReturns() throws Exception {
        LoginDto dummyDto = new LoginDto();
        String dummyLoginId = "DummyLogin";
        dummyDto.setLoginId(dummyLoginId);
        Account dummyAcc = new Account();
        dummyAcc.setLoginId(dummyLoginId);

        when(accountService.postLogin(any())).thenReturn(dummyAcc);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyDto);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Account actualResponse = mapper.readValue(contentAsString, Account.class);

        assertEquals(actualResponse.getLoginId(), dummyLoginId);
    }
    @Test
    public void Register() throws Exception {
        RegisterDto dummyDto = new RegisterDto();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyDto);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(accountService, times(1)).registerNewUser(any());
    }
    @Test
    public void RegisterReturns() throws Exception {
        RegisterDto dummyDto = new RegisterDto();
        String dummyLoginId = "DummyLogin";
        dummyDto.setLoginId(dummyLoginId);
        Account dummyAcc = new Account();
        dummyAcc.setLoginId(dummyLoginId);

        when(accountService.registerNewUser(any())).thenReturn(dummyAcc);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyDto);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Account actualResponse = mapper.readValue(contentAsString, Account.class);

        assertEquals(actualResponse.getLoginId(), dummyLoginId);
    }

    @Test
    public void addPoints() throws Exception {
        AddPointsDto dummyDto = new AddPointsDto();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyDto);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/add-points")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(accountService, times(1)).addPointsToUser(any());
    }

    @Test
    public void addPointsReturns() throws Exception {
        AddPointsDto dummyDto = new AddPointsDto();
        Integer expectedPoints = 10;
        Account dummyAcc = new Account();
        dummyAcc.setPoints(expectedPoints);

        when(accountService.addPointsToUser(any())).thenReturn(dummyAcc);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyDto);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/add-points")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Account actualResponse = mapper.readValue(contentAsString, Account.class);

        assertEquals(actualResponse.getPoints(), expectedPoints);
    }
    @Test
    public void updateAccount() throws Exception {
        Account dummyAcc = new Account();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyAcc);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/accounts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(accountService, times(1)).updateAccount(any());
    }
    @Test
    public void updateAccountReturns() throws Exception {
        Account dummyAcc = new Account();

        String expectedLoginId = "DummyLogin";
        dummyAcc.setLoginId(expectedLoginId);

        when(accountService.updateAccount(any())).thenReturn(dummyAcc);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dummyAcc);

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/accounts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Account actualResponse = mapper.readValue(contentAsString, Account.class);

        assertEquals(actualResponse.getLoginId(), expectedLoginId);
    }

}





















