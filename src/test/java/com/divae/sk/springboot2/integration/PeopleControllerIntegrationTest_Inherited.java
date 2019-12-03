package com.divae.sk.springboot2.integration;

import com.divae.sk.springboot2.SpringBoot2ApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PeopleControllerIntegrationTest_Inherited extends SpringBoot2ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findPerson_success_onePersonFound() throws Exception {
        // @formatter:off
        mockMvc.perform(
                    get("/api/people/{lastName}", "Rat")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName", equalTo("Rat")))
                .andExpect(jsonPath("$.firstName", equalTo("Florence")));
        // @formatter:on
    }

    @Test
    void findPerson_failure_noPersonFound() throws Exception {
        // @formatter:off
        mockMvc.perform(
                    get("/api/people/{lastName}", "Nicht-Existent")
                )
                .andExpect(status().isNotFound());
        // @formatter:on
    }

    @Test
    void findPerson_failure_moreThanOnePersonFound() throws Exception {
        // @formatter:off
        mockMvc.perform(
                        get("/api/people/{lastName}", "Kufer")
                )
                .andExpect(status().isBadRequest());
        // @formatter:on
    }
}
