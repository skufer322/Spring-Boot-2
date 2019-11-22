package com.divae.sk.springboot2.film;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
class Film {

    private Integer id;
    private String title;
    private Integer year;
}
