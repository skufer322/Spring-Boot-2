package com.divae.sk.springboot2.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "spring_modules")
@Data
@NoArgsConstructor
public class SpringModule {

    @Id
    private Long id;
    private String name;
}
