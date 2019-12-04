package com.divae.sk.springboot2.restclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(MyRestClientService.class)
class MyRestClientServiceTest {

    @Autowired
    private MyRestClientService myRestClientService;

    @Autowired
    private MockRestServiceServer mockServer;

    @Test
    void getRemoteInfo() {
        this.mockServer.expect(
                requestTo("https://biking.michael-simons.eu/api/system/info"))
                .andRespond(withSuccess("{\"spring-boot.version\" : \"1337\"}", MediaType.APPLICATION_JSON));

        assertThat(myRestClientService.getRemoteInfo(), is(equalTo("returned: 1337")));
    }
}