package concurrent;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午10:52 2020/10/30
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TestExecuter {
    private static final int CORE_SIZE = 5;

    private static final int MAX_SIZE = 10;

    private static final long KEEP_ALIVE_TIME = 30;

    private static final int QUEUE_SIZE = 5;

    private static final AtomicInteger count = new AtomicInteger(0);
    private static ReentrantLock lock = new ReentrantLock();


    static EnhancedThreadPoolExecutor executor = new EnhancedThreadPoolExecutor(CORE_SIZE, MAX_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new TaskQueue(QUEUE_SIZE));

    public static void main(String[] args) {


        for (; ; ) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {

                        lock.tryLock();
                        if (count.get() % 2 == 0) {
                            System.out.println("A");
                            count.incrementAndGet();
                        }
                        if (count.get() % 2 == 1) {
                            System.out.println("B");
                            count.incrementAndGet();
                        }
                        lock.unlock();

                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

//            System.out.println("线程池中现在的线程数目是：" + executor.getPoolSize() + ",  队列中正在等待执行的任务数量为：" + executor.getQueue().size());
        }


    }

    public void aa() {
        A a = new A();
        B b = new B();

        new Thread(a).start();
        new Thread(b).start();

    }

    static class A implements Runnable {
        ReentrantLock lock;

        @Override
        public void run() {
            lock.lock();
            while (true) {

                if (count.get() % 2 == 0) {
                    System.out.println("A");
                    count.incrementAndGet();
                }
            }


        }
    }


    class B implements Runnable {

        @Override
        public void run() {
            lock.lock();
            while (true) {

                if (count.get() % 2 == 1) {
                    System.out.println("B");
                    count.incrementAndGet();
                }
            }


        }
    }


}


