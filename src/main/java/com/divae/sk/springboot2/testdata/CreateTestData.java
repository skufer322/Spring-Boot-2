package com.divae.sk.springboot2.testdata;

import com.divae.sk.springboot2.film.Film;
import com.divae.sk.springboot2.film.FilmMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class CreateTestData {

    private final FilmMongoRepository repository;

    @PostConstruct
    public void triggerTestDataCreation(){
        Film film = new Film("Das große Fressen");
        repository.save(film);
    }
}
