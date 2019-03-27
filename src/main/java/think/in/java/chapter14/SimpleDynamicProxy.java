package think.in.java.chapter14;

import java.lang.reflect.Proxy;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午11:40 2019/3/27
 */
public class SimpleDynamicProxy {

    public static void consumer(Interface in) {
        in.doSomething();
        in.somethingElse("apple");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);

        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class, RealObject.class},
                new DynamicProxyHandler(realObject));

        consumer(proxy);


    }
}
