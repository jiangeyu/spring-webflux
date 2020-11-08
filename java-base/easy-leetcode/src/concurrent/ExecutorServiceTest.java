package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午10:30 2020/10/30
 */
public class ExecutorServiceTest {

    public static void main(String[] args) throws Exception {
        testInvokeAllTimeout();

    }


    /**
     * 提交的任务集合,一旦有1个任务正常完成(没有抛出异常),会终止其他未完成的任务
     */
    public static void invokeAny1() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<Callable<String>>();

        tasks.add(new SleepSecondCallable("t1", 2));
        tasks.add(new SleepSecondCallable("t2", 1));

        String result = executorService.invokeAny(tasks);

        System.out.println("result=" + result);

        executorService.shutdown();
    }


    /**
     * 没有1个正常完成的任务,invokeAny()方法抛出ExecutionException,封装了任务中元素的异常
     */
    public static void invokeAny2() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<Callable<String>>();

        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());

        String result = executorService.invokeAny(tasks);

        System.out.println("result=" + result);

        executorService.shutdown();


    }


    /**
     * 有异常的任务,有正常的任务,invokeAny()不会抛异常,返回最先正常完成的任务
     */
    public static void invokeAny3() throws Exception
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<Callable<String>>();

        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());

        tasks.add(new SleepSecondCallable("t1", 2));

        String result = executorService.invokeAny(tasks);

        System.out.println("result=" + result);
        executorService.shutdown();

    }


    /**
     * 如果线程在等待invokeAll()执行完成的时候,被中断,会抛出InterruptedException<br>
     * 此时线程池会终止没有完成的任务,这主要是为了减少资源的浪费.
     */
    public static void testInvokeAllWhenInterrupt() throws Exception
    {
        final ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 调用invokeAll的线程
        Thread invokeAllThread = new Thread() {

            @Override
            public void run()
            {
                List<Callable<String>> tasks = new ArrayList<Callable<String>>();
                tasks.add(new SleepSecondCallable("t1", 2));
                tasks.add(new SleepSecondCallable("t2", 2));
                tasks.add(new RandomTenCharsTask());

                // 调用线程会阻塞,直到tasks全部执行完成(正常完成/异常退出)
                try
                {
                    List<Future<String>> results = executorService
                            .invokeAll(tasks);
                    System.out.println("wait for the result." + results.size());
                } catch (InterruptedException e)
                {
                    System.out
                            .println("I was wait,but my thread was interrupted.");
                    e.printStackTrace();
                }

            }
        };

        invokeAllThread.start();

        Thread.sleep(200);

        invokeAllThread.interrupt();

        executorService.shutdown();

    }


    /**
     * 可以通过Future.isCanceled()判断任务是被取消,还是完成(正常/异常)<br>
     * Future.isDone()总是返回true,对于invokeAll()的调用者来说,没有啥用
     */
    public static void testInvokeAllTimeout() throws Exception
    {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Callable<String>> tasks = new ArrayList<Callable<String>>();
        tasks.add(new SleepSecondCallable("t1", 2));
        tasks.add(new SleepSecondCallable("t2", 2));
        tasks.add(new SleepSecondCallable("t3", 3));
        tasks.add(new RandomTenCharsTask());

        List<Future<String>> results = executorService.invokeAll(tasks, 1,
                TimeUnit.SECONDS);

        System.out.println("wait for the result." + results.size());

        for (Future<String> f : results)
        {
            System.out.println("isCanceled=" + f.isCancelled() + ",isDone="
                    + f.isDone());
        }

        executorService.shutdown();

    }
}