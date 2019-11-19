package com.divae.sk.springboot2.controller;

import com.divae.sk.springboot2.data.SpringModule;
import com.divae.sk.springboot2.data.SpringModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpringModulesController {

    private final SpringModuleRepository repository;

    @GetMapping("/spring-modules")
    public List<SpringModule> getModules(){
        return repository.findAll();
    }
}
