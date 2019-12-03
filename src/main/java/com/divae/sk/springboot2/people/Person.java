package com.divae.sk.springboot2.people;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Person {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    @Builder(toBuilder = true)
    public Person(@NonNull String firstName, @NonNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
