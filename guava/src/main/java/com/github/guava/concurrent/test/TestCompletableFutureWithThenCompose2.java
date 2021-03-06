package com.github.guava.concurrent.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by tony on 2017/9/19.
 */
public class TestCompletableFutureWithThenCompose2 {

    public static void main(String[] args) {

        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> "100")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "100"))
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> Double.parseDouble(s)));

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
