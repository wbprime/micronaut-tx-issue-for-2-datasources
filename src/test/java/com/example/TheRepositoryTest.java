package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class TheRepositoryTest {
    @Inject
    TheRepository repository;

    @Test
    void test1() {
        repository.createTableInA();
    }

    @Test
    void test2() {
        repository.createTableInB();
    }

    @Test
    void test3() {
        repository.doSomethingInTransaction();
    }
}