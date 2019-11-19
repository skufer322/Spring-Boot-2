package com.divae.sk.springboot2.testdata;

import com.divae.sk.springboot2.author.Author;
import com.divae.sk.springboot2.author.AuthorRepository;
import com.divae.sk.springboot2.book.Book;
import com.divae.sk.springboot2.book.BookRepository;
import com.divae.sk.springboot2.book.LanguageEnum;
import com.divae.sk.springboot2.publisher.Publisher;
import com.divae.sk.springboot2.publisher.PublisherRepository;
import static java.util.function.Predicate.not;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CreateTestData {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @PostConstruct
    public void triggerTestDataCreation() {
        createPublishers();
        List<Book> books = createBooks();
        createAuthors(books);
    }

    private void createAuthors(List<Book> books) {
        Predicate<Book> isHyperion = book -> book.getTitle().contains("Hyperion");
        Author dan_simmons = Author.builder()
                .firstName("Dan")
                .lastName("Simmons")
                .books(books.stream().filter(isHyperion).collect(Collectors.toList()))
                .build();
        authorRepository.save(dan_simmons);
        Author peter_f_hamilton = Author.builder()
                .firstName("Peter F.")
                .lastName("Hamilton")
                .books(books.stream().filter(not(isHyperion)).collect(Collectors.toList()))
                .build();
        authorRepository.save(peter_f_hamilton);
    }

    private List<Book> createBooks() {
        Publisher basteiLuebbe = publisherRepository.findOneByName("Bastei Lübbe").orElseThrow(RuntimeException::new);
        Publisher spectra = publisherRepository.findOneByName("Spectra").orElseThrow(RuntimeException::new);

        Book hyperion = Book.builder()
                .isbn("0553283685")
                .title("Hyperion")
                .language(LanguageEnum.EN)
                .publisher(basteiLuebbe)
                .build();
        Book fall_of_hyperion = Book.builder()
                .isbn("0553288202")
                .title("The Fall of Hyperion")
                .language(LanguageEnum.EN)
                .publisher(basteiLuebbe)
                .build();
        Book sternentraueme = Book.builder()
                .isbn("3404232542")
                .title("Sternenträume")
                .language(LanguageEnum.DE)
                .publisher(spectra)
                .build();
        Book drachenfeuer = Book.builder()
                .isbn("3404232569")
                .title("Drachenfeuer")
                .language(LanguageEnum.DE)
                .publisher(basteiLuebbe)
                .build();

        List<Book> books = List.of(hyperion, fall_of_hyperion, sternentraueme, drachenfeuer);

        return (List<Book>) bookRepository.saveAll(books);
    }

    private void createPublishers() {
        Publisher basteiLuebbe = Publisher.builder()
                .name("Bastei Lübbe")
                .build();
        Publisher spectra = Publisher.builder()
                .name("Spectra")
                .build();

        List<Publisher> publishers = List.of(basteiLuebbe, spectra);

        publisherRepository.saveAll(publishers);
    }
}
