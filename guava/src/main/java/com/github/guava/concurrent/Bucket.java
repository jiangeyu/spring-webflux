package com.github.guava.concurrent;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午6:45 2019/10/31
 */
public class Bucket {

    private final ConcurrentLinkedQueue<Integer> container = new ConcurrentLinkedQueue<>();

    private final static int BUCKET_LIMIT = 1000;

    private final RateLimiter limiter = RateLimiter.create(10);

    private final Monitor offerMonitor = new Monitor();
    private final Monitor pollMonitor = new Monitor();

    public void submit(Integer data) {
        if(offerMonitor.enterIf(offerMonitor.newGuard(() -> container.size() < BUCKET_LIMIT))) {
            try {
                container.offer(data);

            } catch (Exception e) {

            } finally {
                offerMonitor.leave();
            }
        }

    }

    public void takeThenConsume(Consumer<Integer> consumer) {
        if(pollMonitor.enterIf(pollMonitor.newGuard(() -> !container.isEmpty()))) {
            try {
                consumer.accept(container.poll());
            } finally {
                pollMonitor.leave();
            }
        }
    }


}
