package com.divae.sk.springboot2.people;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleService peopleService;

    @GetMapping("/api/people")
    public List<Person> getPersons(){
        return peopleService.getAllPersons();
    }

    @GetMapping("/api/people/{lastName}")
    public Person getPerson(@PathVariable String lastName){
        return peopleService.getPersonByLastName(lastName);
    }
}
