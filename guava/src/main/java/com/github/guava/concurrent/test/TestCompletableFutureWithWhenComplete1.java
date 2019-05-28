package com.github.guava.concurrent.test;

import java.util.concurrent.CompletableFuture;

/**
 * Created by tony on 2017/9/20.
 */
public class TestCompletableFutureWithWhenComplete1 {

    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s->s+" World")
                .thenApply(s->s+ "\nThis is CompletableFuture demo")
                .thenApply(String::toLowerCase)
                .whenComplete((result, throwable) -> System.out.println(result));
    }
}
