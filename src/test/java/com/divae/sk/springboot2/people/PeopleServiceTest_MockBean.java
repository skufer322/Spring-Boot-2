package com.divae.sk.springboot2.people;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = PeopleService.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PeopleServiceTest_MockBean {

    private PeopleService peopleService;

    @MockBean
    private PersonRepository personRepository;

    @BeforeAll
    void setup() {
        peopleService = new PeopleService(personRepository);
    }

    @Test
    void testMockedBean_blank() {
        when(personRepository.findAll()).thenReturn(List.of(new Person("person", "test")));

        List<Person> people = peopleService.getAllPersons();

        assertThat(people, is(notNullValue()));
    }

    @Test
    void testMockedBean_trained() {
        peopleService = new PeopleService(personRepository);

        when(personRepository.findAll()).thenReturn(List.of(new Person("person", "test")));

        List<Person> people = peopleService.getAllPersons();

        assertThat(people, is(notNullValue()));
        assertThat(people.size(), is(1));
        assertThat(people.get(0), equalTo(new Person("person", "test")));
    }
}
