package com.divae.sk.springboot2.extendconfiguration;

import lombok.Data;

@Data
public class MyBean {

    private final String string;

    public String getString() {
        return string;
    }
}
