package com.github.guava.concurrent.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 用runAsync()创建CompletableFuture
 * Created by tony on 2017/9/16.
 */
public class TestCompletableFutureWithRunAsync {

    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello");
        });

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("CompletableFuture");
    }
}
