package com.divae.sk.springboot2.author;

import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AuthorRepository extends Repository<Author, Long> {

    List<Author> findAll();

    List<Author> findAllByOrderByLastName();

    Author findById(Long id);

    void save(Author author);
}
