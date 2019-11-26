package com.divae.sk.springboot2.message;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder(toBuilder = true)
class MyMessageObject implements Serializable {

    private long id;
    private String info;
}
