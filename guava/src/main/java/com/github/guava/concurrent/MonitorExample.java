package com.github.guava.concurrent;

import com.google.common.util.concurrent.Monitor;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午5:40 2019/10/31
 */
public class MonitorExample {


    public static void main(String[] args) {
        final MonitorGuard guard = new MonitorGuard();
        AtomicInteger COUNTER = new AtomicInteger(0);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (; ; ) {
                    try {
                        int data = COUNTER.getAndIncrement();
                        System.out.println(currentThread() + " offer " + data);
                        guard.offer(data);
                        TimeUnit.MILLISECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i <= 2; i++) {
            new Thread(() ->
            {
                for (; ; )
                    try {
                        int data = guard.take();
                        System.out.println(currentThread() + " take " + data);
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }).start();
        }
    }


    static class MonitorGuard {
        private final LinkedList<Integer> queue = new LinkedList<>();

        private final int MAX = 10;

        private final Monitor monitor = new Monitor();

        private final Monitor.Guard CAN_OFFER = monitor.newGuard(() -> queue.size() < MAX);

        private final Monitor.Guard CAN_TAKE = monitor.newGuard(() -> !queue.isEmpty());

        public void offer(int value) {
            try {
                monitor.enterWhen(CAN_OFFER);
                queue.addLast(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                monitor.leave();
            }

        }

        public int take() {
            try
            {
                monitor.enterWhen(CAN_TAKE);
                return queue.removeFirst();
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            } finally
            {
                monitor.leave();
            }
        }

    }

}
