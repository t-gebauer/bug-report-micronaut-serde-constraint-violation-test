package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class TestControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void shouldDeserializeConstraintViolationProblem() {
        var requestBody = "{\"type\":\"https://zalando.github.io/problem/constraint-violation\",\"title\":\"Constraint Violation\",\"status\":400,\"violations\":[{\"field\":\"foo.bar\",\"message\":\"must not be blank\"}]}";
        var request     = HttpRequest.POST("/", requestBody);

        var response = httpClient.toBlocking().exchange(request);
        assertEquals(HttpStatus.OK, response.getStatus());
    }
}
