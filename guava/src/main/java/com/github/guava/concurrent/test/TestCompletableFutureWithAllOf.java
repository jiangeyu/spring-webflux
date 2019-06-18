package com.github.guava.concurrent.test;


import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tony on 2017/9/21.
 */
public class TestCompletableFutureWithAllOf {

    public static void main(String[] args) {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "thread1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "thread2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
                System.out.println(1/0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "thread3";
        });



        CompletableFuture.allOf(future1, future2, future3)
                .thenApply(v ->
                Stream.of(future1, future2, future3)
                        .map(CompletableFuture::join)
                        .collect(Collectors.joining(" ")))
                .thenAccept(System.out::print);

    }
}
