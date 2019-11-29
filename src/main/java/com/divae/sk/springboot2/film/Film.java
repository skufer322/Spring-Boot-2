package com.divae.sk.springboot2.film;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "films")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Film {

    @Id
    @Setter(AccessLevel.NONE)
    private String id;
    @NonNull private String title;
    @NonNull private Integer year;

    @Builder(toBuilder = true)
    public Film(@NonNull String title, @NonNull Integer year){
        this.title = title;
        this.year = year;
    }
}
