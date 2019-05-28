package com.github.guava.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:46 2019/5/28
 */
public class TestCompletableFutureWithHandle {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> "100")
                .thenApply(s -> s + "100")
                .handle((s, t) -> s != null ? Double.parseDouble(s) : 0);

        System.out.println(future.get());

        CompletableFuture.supplyAsync(() -> "hello world")
                .thenApply( s -> {
                    s = null;
                    int length = s.length();
                    return length;
                }).thenAccept( i -> System.out.println(i))
                .exceptionally(t -> {
                    System.out.println("unexpected error: " + t);
                    return null;
                });


        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s->s+" World")
                .thenApply(s->s+ "\nThis is CompletableFuture demo")
                .thenApply(String::toLowerCase)
                .thenAccept(System.out::print);


        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "100");
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> 100);

        CompletableFuture<Void> future5 = future3.thenAcceptBoth(future4, (s, i) -> System.out.println(Double.parseDouble(s + i)));

        try {
            future5.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
