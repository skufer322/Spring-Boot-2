package com.divae.sk.springboot2.extendconfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class ExtendConfigurationTest {

    @TestConfiguration
    static class AdditionalConfiguration {

        @Bean
        RestTemplate restTemplateTest(RestTemplateBuilder restTemplateBuilder) {
            return restTemplateBuilder.basicAuthentication("8ffc7356-12f6-29fa-7446-bf3a687f9a7f", "6b74d761-489e-4582-aa28-3603d5583f25").build();
        }

        @Bean
        MyBean myBeanTest() {
            return new MyBean("HALLO");
        }
    }

    @Autowired
    private MyBean myBeanTest;
    @Autowired
    private RestTemplate restTemplateTest;

    @Test
    void testExtendedConfiguration_myBeanTest() {
        assertThat(myBeanTest.getString(), equalTo("HALLO"));
    }

    @Test
    void testExtendedConfiguration_restTemplateTest() {
        String url = "https://matrix42.channelcrowd.com/api/deals";

        ResponseEntity<String> response = restTemplateTest.getForEntity(url, String.class);

        assertThat(response, is(notNullValue()));
    }
}
