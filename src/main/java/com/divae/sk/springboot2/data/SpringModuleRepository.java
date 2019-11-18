package com.divae.sk.springboot2.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpringModuleRepository extends CrudRepository<SpringModule, Long> {

    List<SpringModule> findAll();
}
