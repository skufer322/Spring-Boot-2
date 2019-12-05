package com.divae.sk.springboot2.testdata;

import com.divae.sk.springboot2.book.Book;
import com.divae.sk.springboot2.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateTestData {

    private final BookRepository bookRepository;

    @PostConstruct
    private void createTestData() {
        createBooks();
    }

    private void createBooks() {
        Book book1 = Book.builder()
                .title("Das große Fressen")
                .author("Dan Simmons")
                .build();

        Book book2 = Book.builder()
                .title("Die unerträgliche Schwere der Leere")
                .author("Milan Kundera")
                .build();

        bookRepository.saveAll(List.of(book1, book2));
    }
}
