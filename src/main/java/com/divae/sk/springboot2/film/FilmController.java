package com.divae.sk.springboot2.film;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmController {

    private final FilmMongoRepository filmMongoRepository;

    @GetMapping("/films")
    public List<Film> getFilms(){
        return filmMongoRepository.findAll();
    }

    @GetMapping("/films/newer-than/{year}")
    public List<Film> getFilmsFilteredByYearGreaterThan(@PathVariable final int year){
        return filmMongoRepository.findAllByYearGreaterThan(year);
    }

    @GetMapping("/films/older-than/{year}")
    public List<Film> getFilmsFilteredByYearSmallerThan(@PathVariable final int year){
        return filmMongoRepository.findAllByYearLessThan(year);
    }
}
