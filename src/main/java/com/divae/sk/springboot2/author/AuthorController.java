package com.divae.sk.springboot2.author;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository repository;

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return repository.findAll();
    }

    @GetMapping("/authors/ordered/lastname")
    public List<Author> getAuthorsOrderByLastName(){
        return  repository.findAllByOrderByLastName();
    }
}
