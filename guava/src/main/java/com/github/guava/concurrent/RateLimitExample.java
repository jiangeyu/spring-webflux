package com.github.guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午5:22 2019/10/31
 */
public class RateLimitExample {


    private final static RateLimiter limiter = RateLimiter.create(0.5d);

    private final static Semaphore semaphore = new Semaphore(3);


    private static void testSemaphore() {
        try {
            semaphore.acquire();
            System.out.println(currentThread() + "is coming and do work");
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(currentThread() + "release the semaphore");

        }
    }

    private static void testLimiter( ) {
        System.out.println(currentThread() + " wait " + limiter.acquire());

    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0,10).forEach(i -> executorService.submit(RateLimitExample::testLimiter));
    }
}
