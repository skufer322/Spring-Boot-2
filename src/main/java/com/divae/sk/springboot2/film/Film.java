package com.divae.sk.springboot2.film;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "films")
@Getter
public class Film {

    private String id;
    private String title;

    public Film(String title) {
        this.title = title;
    }
}
