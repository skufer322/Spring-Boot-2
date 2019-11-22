package com.divae.sk.springboot2.film;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

@DataMongoTest
class FilmTest {

    // es macht wohl wenig Sinn, Repositories zu testen -> bei Tests besser mit MongoTemplate arbeiten
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void test_integrated_flapoodle_and_mongoTemplate() {
        Film film = Film.builder()
                .title("Das große Fressen")
                .year(1997)
                .build();
        mongoTemplate.save(film);

        assertThat(film.getId(), notNullValue());
        assertThat(mongoTemplate.findAll(Film.class).size(), is(1));
    }
}
