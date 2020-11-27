package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:12 2020/11/5
 */
public class ReentrantLockPrint {

    public static class Inner implements Runnable {
        private int threadId;
        private ReentrantLock lock;
        private static int count = 0;
        private String name;

        private Condition condition;
        private Condition nextCondition;

        public Inner(int threadId, ReentrantLock lock, String name, Condition condition, Condition nextCondition) {
            this.threadId = threadId;
            this.lock = lock;
            this.name = name;
            this.condition = condition;
            this.nextCondition = nextCondition;
        }


        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (count % 3 == threadId) {
                        System.out.println(name);
                        count++;
                        nextCondition.signal();

                    } else {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition0 = lock.newCondition();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        new Thread(new Inner(0, lock, "A", condition0, condition1)).start();
        new Thread(new Inner(1, lock, "B", condition1, condition2)).start();
        new Thread(new Inner(2, lock, "C", condition2, condition0)).start();

    }
}
