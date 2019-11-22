package com.divae.sk.springboot2.film;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FilmMongoRepository extends MongoRepository<Film, Long> {

    List<Film> findAll();

    List<Film> findAllByYearGreaterThan(int year);

    List<Film> findAllByYearLessThan(int year);
}
