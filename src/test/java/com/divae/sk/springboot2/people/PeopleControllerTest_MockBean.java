package com.divae.sk.springboot2.people;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;

@WebMvcTest(PeopleController.class)
public class PeopleControllerTest_MockBean {

    @Autowired
    private MockMvc mockMvc;

    @MockBean(PeopleService.class)
    private PeopleService peopleService;

    @Test
    void testMockedBean() throws Exception {
        when(peopleService.getAllPersons()).thenReturn(List.of(new Person("person", "test")));

        mockMvc.perform(
                    get("/api/people")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].lastName", equalTo("test")))
                .andExpect(jsonPath("$[0].firstName", equalTo("person")));
    }
}
