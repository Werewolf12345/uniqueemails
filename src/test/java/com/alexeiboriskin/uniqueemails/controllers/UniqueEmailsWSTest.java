package com.alexeiboriskin.uniqueemails.controllers;

import org.json.JSONArray;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class UniqueEmailsWSTest {

    private MockMvc mockMvc;

    @BeforeAll
    void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void test_get_unique_emails_count() throws Exception {
        String[] emails = new String[]{"test.email@gmail.com", "test.email+spam@gmail.com", "testemail@gmail.com"};
        JSONArray ja = new JSONArray(emails);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emailscount")
                .content(ja.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(1, Integer.valueOf(result.getResponse().getContentAsString()));
    }

}