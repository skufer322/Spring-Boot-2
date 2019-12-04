package com.divae.sk.springboot2.integration;

import com.divae.sk.springboot2.people.PeopleController;
import com.divae.sk.springboot2.people.PeopleService;
import com.divae.sk.springboot2.people.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PeopleController.class)
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
