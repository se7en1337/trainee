package org.example.demo.controller;

import jdk.jfr.ContentType;
import org.example.demo.dto.PersonDTO;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getPersonById() throws Exception {
        MvcResult res;
        res = mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/person/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        JSONObject dtoJson = new JSONObject();
        dtoJson.put("id", 1);
        dtoJson.put("firstname", "Oleg");
        dtoJson.put("surname", "Leonov");
        dtoJson.put("age", 20);
        Assertions.assertEquals(dtoJson.toString(), new JSONObject(res.getResponse().getContentAsString()).toString());
    }

    @Test
    public void badRequest() throws Exception {
        MvcResult res;
        res = mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/person/999")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()).andReturn();
        Assertions.assertEquals("Person not found", res.getResponse().getErrorMessage());
    }

}
