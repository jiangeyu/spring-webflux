package concurrent;

import java.util.concurrent.Callable;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:53 2020/10/29
 */
public class ExceptionCallable implements Callable<String> {

    private String name = null;

    public ExceptionCallable()
    {

    }

    public ExceptionCallable(String name)
    {
        this.name = name;
    }


    @Override
    public String call() throws Exception {

        System.out.println("begin to ExceptionCallable.");

        System.out.println(name.length());

        System.out.println("end to ExceptionCallable.");

        return name;
    }
}
