package com.divae.sk.springboot2.integration;

import com.divae.sk.springboot2.people.PeopleController;
import com.divae.sk.springboot2.people.PeopleService;
import com.divae.sk.springboot2.testdata.CreateTestDataTestsOnly;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(includeFilters
        = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {PeopleController.class, PeopleService.class, CreateTestDataTestsOnly.class} // sinnvoller wäre es hier, PeopleService zu mocken -> aber für Demonstrationszwecke mit DataJPA
))
@AutoConfigureDataJpa
public class PeopleControllerIntegrationTest_Standalone {

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
