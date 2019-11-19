package com.divae.sk.springboot2.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Book {

    @Id
    private String isbn;

    private String title;

    @Enumerated(EnumType.STRING)
    private LanguageEnum language;
}
