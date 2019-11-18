package com.divae.sk.springboot2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JdbcController {

    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/endpoint")
    public List<String> getJdbcData(){
        return jdbcTemplate.queryForList("SELECT name FROM spring_modules ORDER BY name asc", String.class);
    }
}
