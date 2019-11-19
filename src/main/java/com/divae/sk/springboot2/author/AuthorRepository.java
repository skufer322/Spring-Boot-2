package com.divae.sk.springboot2.author;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface AuthorRepository extends Repository<Author, Long> {

    List<Author> findAll();

    List<Author> findAllByIdIn(List<Long> ids);

    List<Author> findAllByOrderByLastName();

    Optional<Author> findById(Long id);

    void save(Author author);
}
