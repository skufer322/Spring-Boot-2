package com.divae.sk.springboot2.book;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String title;

    private String author;

    @Builder(toBuilder = true)
    public Book(@NonNull String title, @NonNull String author){
        this.title = title;
        this.author = author;
    }
}
