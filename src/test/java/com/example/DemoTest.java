package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class DemoTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void testItWorks() {
        final String str = httpClient.toBlocking().retrieve(HttpRequest.GET("/hello"));
        System.out.println(str);
    }

}
