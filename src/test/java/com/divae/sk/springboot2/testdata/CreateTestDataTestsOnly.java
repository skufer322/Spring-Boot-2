package com.divae.sk.springboot2.testdata;

import com.divae.sk.springboot2.people.PeopleRepository;
import com.divae.sk.springboot2.people.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Profile("test") wird nicht benötigt, da Komponente nur im Test-Scope erzeugt wird.
 */
@Component
@RequiredArgsConstructor
public class CreateTestDataTestsOnly {

    private final PeopleRepository peopleRepository;

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
        Person person3 = Person.builder()
                .firstName("Matthias")
                .lastName("Kufer")
                .build();

        List<Person> personList = List.of(person1, person2, person3);

        peopleRepository.saveAll(personList);
    }
}
