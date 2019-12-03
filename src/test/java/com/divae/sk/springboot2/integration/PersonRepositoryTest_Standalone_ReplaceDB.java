package com.divae.sk.springboot2.integration;

import com.divae.sk.springboot2.people.Person;
import com.divae.sk.springboot2.people.PersonRepository;
import com.divae.sk.springboot2.testdata.CreateTestDataTestsOnly;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DataJpaTest(includeFilters
        = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {CreateTestDataTestsOnly.class}
))
class PersonRepositoryTest_Standalone_ReplaceDB {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void testNumberOfPeopleInTestData() {
        List<Person> people = personRepository.findAll();

        assertThat(people.size(), is(3));
    }

}
