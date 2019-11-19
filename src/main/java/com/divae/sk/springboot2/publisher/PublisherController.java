package com.divae.sk.springboot2.publisher;

import com.divae.sk.springboot2.author.Author;
import com.divae.sk.springboot2.jdbc.ComplexQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PublisherController {

    private final ComplexQueryRepository complexQueryRepository;

    @GetMapping("/publishers/{id}/authors")
    public List<Author> getAuthorsForPublisherId(@PathVariable final Long id){
        return complexQueryRepository.getAuthorsForPublisherId(id);
    }
}
