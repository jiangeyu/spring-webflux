package concurrent;

import java.util.concurrent.Semaphore;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:47 2020/11/5
 */
public class TurnsSemaphore {

    static class Inner implements Runnable{
        private Semaphore mySemaphore;
        private Semaphore nextSemaphore;
        private static int num = 0;
        private int end = 75;
        private int threadId;

        public Inner(Semaphore mySemaphore, Semaphore nextSemaphore, int threadId) {
            this.mySemaphore = mySemaphore;
            this.nextSemaphore = nextSemaphore;
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while(true){
                try {
                    mySemaphore.acquire();
                    System.out.println("线程" + threadId + ":" + num++);
                    nextSemaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore0=new Semaphore(1);
        Semaphore semaphore1=new Semaphore(0);
        Semaphore semaphore2=new Semaphore(0);
        new Thread(new Inner(semaphore0,semaphore1,0)).start();
        new Thread(new Inner(semaphore1,semaphore2,1)).start();
        new Thread(new Inner(semaphore2,semaphore0,2)).start();
    }
}
