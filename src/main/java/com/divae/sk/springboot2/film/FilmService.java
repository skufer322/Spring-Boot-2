package com.divae.sk.springboot2.film;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class FilmService {

    private List<Film> films;

    List<Film> getAllFilms() {
        return films;
    }

    @Cacheable(
            cacheNames = "filmsBeforeCache"
    )
    public List<Film> getFilmsBefore(int year) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        return films.stream()
                .filter(film -> film.getYear() < year)
                .collect(Collectors.toList());
    }

    @Cacheable(
            cacheNames = "filmsAfterCache"
    )
    public List<Film> getFilmsAfter(int year) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return films.stream()
                .filter(film -> film.getYear() > year)
                .collect(Collectors.toList());
    }

    @PostConstruct
    private void createFilmsForTest() {
        films = new ArrayList<>();
        Film film1 = Film.builder()
                .id(1)
                .title("Das große Fressen")
                .year(1970)
                .build();
        Film film2 = Film.builder()
                .id(2)
                .title("Honk if you are horny")
                .year(2010)
                .build();
        films.addAll(List.of(film1, film2));
    }
}
