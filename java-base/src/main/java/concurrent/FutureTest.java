package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:34 2021/4/25
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ComputeFuture computeFuture = new ComputeFuture();
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> future = pool.submit(computeFuture);
        System.out.println(future.get());
    }
}
