package com.github.guava.concurrent.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by tony on 2017/9/19.
 */
public class TestCompletableFutureWithThenCompose1 {

    public static void main(String[] args) {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
               Thread.sleep(1000);
               return "hello";
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        })
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
