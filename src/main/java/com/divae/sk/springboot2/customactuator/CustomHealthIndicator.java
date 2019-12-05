package com.divae.sk.springboot2.customactuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        LocalDate now = LocalDate.now();

        return now.getDayOfWeek() == DayOfWeek.THURSDAY ?
                Health.outOfService()
                        .withDetail("out of service always on", now.getDayOfWeek())
                        .build() :
                Health.up().build();
    }
}
