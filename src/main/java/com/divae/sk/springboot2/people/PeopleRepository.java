package com.divae.sk.springboot2.people;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();

    List<Person> findByLastName(String lastName);
}
