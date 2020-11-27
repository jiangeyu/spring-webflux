package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:50 2020/10/29
 */
public class SleepSecondCallable implements Callable<String> {

    String name;
    int seconds;

    SleepSecondCallable(String name, int seconds) {
        this.name = name;
        this.seconds = seconds;
    }


    @Override
    public String call() throws Exception {
        System.out.println(name + ",begin to execute");

        TimeUnit.SECONDS.sleep(seconds);

        System.out.println(name + ",end execute");

        return name + "SleepCallable";
    }
}
