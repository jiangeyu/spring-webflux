package concurrent;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:32 2021/4/25
 */
public class ComputeFuture implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("start thead");
        return new Random().nextInt();
    }
}
