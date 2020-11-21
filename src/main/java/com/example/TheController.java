package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Controller
public class TheController {
    private final TheRepository repository;

    @Inject
    public TheController(TheRepository repository) {
        this.repository = repository;
    }

    @Get("/hello")
    public CompletionStage<String> hello() {
        repository.createTableInA();
        repository.doSomethingInTransaction();
        return CompletableFuture.completedFuture("Hello");
    }
}
