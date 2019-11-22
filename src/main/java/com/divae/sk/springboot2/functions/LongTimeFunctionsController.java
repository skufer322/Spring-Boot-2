package com.divae.sk.springboot2.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class LongTimeFunctionsController {

    private final LongTimeFunctionsService service;

    @GetMapping("/function/pi/{digits}")
    public BigDecimal getFunctionPiWithDigits(@PathVariable final int digits) {
        return service.getPiWithNDigits(digits);
    }
}
