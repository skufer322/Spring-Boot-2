package com.divae.sk.springboot2.testdata;

import com.divae.sk.springboot2.people.Person;
import com.divae.sk.springboot2.people.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
@Profile("!test")
public class CreateTestData {

    private final PersonRepository personRepository;

    @PostConstruct
    public void createTestData() {
        createAndSavePeople();
    }

    private void createAndSavePeople() {
        Person person1 = Person.builder()
                .firstName("Florence")
                .lastName("Rat")
                .build();
        Person person2 = Person.builder()
                .firstName("Stefan")
                .lastName("Kufer")
                .build();

        List<Person> personList = List.of(person1, person2);

        personRepository.saveAll(personList);
    }
}
