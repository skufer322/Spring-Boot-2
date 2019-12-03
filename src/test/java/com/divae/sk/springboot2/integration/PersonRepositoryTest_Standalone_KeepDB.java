package com.divae.sk.springboot2.integration;

import com.divae.sk.springboot2.people.Person;
import com.divae.sk.springboot2.people.PersonRepository;
import com.divae.sk.springboot2.testdata.CreateTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ActiveProfiles("with-mssql")
@DataJpaTest(includeFilters
        = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {CreateTestData.class}
))
@AutoConfigureTestDatabase(replace = NONE)
class PersonRepositoryTest_Standalone_KeepDB {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void testNumberOfPeopleInTestData() {
        List<Person> people = personRepository.findAll();

        assertThat(people.size(), is(2));
    }

}
