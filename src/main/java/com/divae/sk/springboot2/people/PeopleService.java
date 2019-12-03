package com.divae.sk.springboot2.people;

import com.divae.sk.springboot2.people.exceptions.MoreThanOnePersonFoundException;
import com.divae.sk.springboot2.people.exceptions.PersonNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PeopleService {

    private final PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonByLastName(String lastName) {
        List<Person> foundPersons = personRepository.findByLastName(lastName);

        if (foundPersons.size() > 1) {
            throw new MoreThanOnePersonFoundException();
        }

        return foundPersons.stream().findFirst().orElseThrow(PersonNotFoundException::new);
    }
}
