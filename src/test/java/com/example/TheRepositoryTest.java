package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class TheRepositoryTest {
    @Inject
    TheRepository repository;

    @Test
    void test() {
        repository.createTableInA();
    }
}