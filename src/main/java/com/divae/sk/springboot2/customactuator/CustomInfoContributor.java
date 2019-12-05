package com.divae.sk.springboot2.customactuator;

import lombok.Builder;
import lombok.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("customInfo-computedLongValue", 13L*13L);
        builder.withDetail("customInfo-string", "Hello Info World!");
        builder.withDetail("customInfo-customObject", new Car("Subaru", 255));
    }

    @Value
    @Builder
    private static class Car {
        String name;
        Integer topSpeed;
    }
}
