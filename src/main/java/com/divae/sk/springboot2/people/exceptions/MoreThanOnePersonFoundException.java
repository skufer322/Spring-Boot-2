package com.divae.sk.springboot2.people.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MoreThanOnePersonFoundException extends RuntimeException {
}
