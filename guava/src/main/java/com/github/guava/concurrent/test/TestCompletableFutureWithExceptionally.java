package com.github.guava.concurrent.test;

import java.util.concurrent.CompletableFuture;

/**
 * Created by tony on 2017/9/21.
 */
public class TestCompletableFutureWithExceptionally {

    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> "hello world")
                .thenApply(s -> {
                    s = null;
                    int length = s.length();
                    return length;
                }).thenAccept(i -> System.out.println(i))
                .exceptionally(t -> {
                    System.out.println("Unexpected error:" + t);
                    return null;
                });
    }
}
