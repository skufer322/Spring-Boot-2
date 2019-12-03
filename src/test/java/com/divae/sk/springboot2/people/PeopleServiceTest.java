package com.divae.sk.springboot2.people;

import com.divae.sk.springboot2.people.exceptions.MoreThanOnePersonFoundException;
import com.divae.sk.springboot2.people.exceptions.PersonNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PeopleServiceTest {

    @InjectMocks
    private PeopleService peopleService;

    @Mock
    private PeopleRepository peopleRepository;

    @BeforeAll
    static void setupMocks() {
        MockitoAnnotations.initMocks(PeopleServiceTest.class);
    }

    @Test
    void getPersonByLastName_onePerson() {
        String personLastNameToSearch = "onePerson";
        when(peopleRepository.findByLastName(personLastNameToSearch)).thenReturn(List.of(new Person("firstName", "lastName")));

        Person person = peopleService.getPersonByLastName(personLastNameToSearch);

        assertThat(person.getLastName(), is("lastName"));
    }

    @Test
    void getPersonByLastName_noPerson(){
        String personLastNameToSearch = "inexistentPerson";
        when(peopleRepository.findByLastName(personLastNameToSearch)).thenReturn(List.of());

        Assertions.assertThrows(PersonNotFoundException.class, () -> peopleService.getPersonByLastName(personLastNameToSearch));
    }

    @Test
    void getPersonByLastName_multiplePersons(){
        String personLastNameToSearch = "multipleExistingPersons";
        when(peopleRepository.findByLastName(personLastNameToSearch)).thenReturn(List.of(new Person("aFirst", "aLast"), new Person("bFirst", "bLast")));

        Assertions.assertThrows(MoreThanOnePersonFoundException.class, () -> peopleService.getPersonByLastName(personLastNameToSearch));
    }
}
