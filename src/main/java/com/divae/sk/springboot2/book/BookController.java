package com.divae.sk.springboot2.book;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository bookRepository;
    private final MeterRegistry meterRegistry;

    private final Counter counter;

    public BookController(BookRepository bookRepository, MeterRegistry meterRegistry) {
        this.bookRepository = bookRepository;
        this.meterRegistry = meterRegistry;

        this.counter = meterRegistry.counter("BookController.allBookCounter");
    }

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        counter.increment();
        return bookRepository.findAll();
    }
}
