package com.divae.sk.springboot2.author;

import com.divae.sk.springboot2.jdbc.ComplexQueryRepository;
import com.divae.sk.springboot2.publisher.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final ComplexQueryRepository complexQueryRepository;

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/authors/ordered/lastname")
    public List<Author> getAuthorsOrderByLastName() {
        return authorRepository.findAllByOrderByLastName();
    }

    @GetMapping("/authors/author/{id}")
    public Author getAuthorById(@PathVariable final Long id) {
        return authorRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @GetMapping("/authors/{id}/publishers")
    public List<Publisher> getPublishersOfAuthor(@PathVariable final Long id){
        return complexQueryRepository.getPublishersForAuthorId(id);
    }
}
