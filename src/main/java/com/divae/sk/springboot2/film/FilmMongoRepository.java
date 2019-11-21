package com.divae.sk.springboot2.film;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmMongoRepository extends MongoRepository<Film, Long> {
}
