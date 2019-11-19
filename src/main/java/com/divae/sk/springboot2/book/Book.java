package com.divae.sk.springboot2.book;

import com.divae.sk.springboot2.publisher.Publisher;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
public class Book {

    @Id
    private String isbn;

    private String title;

    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

    @OneToOne
    private Publisher publisher;
}
