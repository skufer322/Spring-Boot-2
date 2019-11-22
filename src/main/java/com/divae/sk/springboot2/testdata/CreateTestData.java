package com.divae.sk.springboot2.testdata;

import com.divae.sk.springboot2.film.Film;
import com.divae.sk.springboot2.film.FilmMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateTestData {

    private final FilmMongoRepository repository;

    @PostConstruct
    public void triggerTestDataCreation(){
        clearDb();
        createFilms();
    }

    private void clearDb() {
        repository.deleteAll();
    }

    private void createFilms() {
        Film film1 = Film.builder()
                .title("Das große Fressen")
                .year(1988)
                .build();
        Film film2 = Film.builder()
                .title("Event Horizon")
                .year(2000)
                .build();
        Film film3 = Film.builder()
                .title("Bad Santa")
                .year(2001)
                .build();
        Film film4 = Film.builder()
                .title("Mission Impossible")
                .year(1997)
                .build();
        List<Film> films = List.of(film1, film2, film3, film4);
        repository.saveAll(films);
    }
}
