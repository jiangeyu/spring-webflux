package think.in.java.chapter14;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    public static void consumer(String  in) {
        System.out.println(in);
    }





    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RealObject realObject = new RealObject();
        consumer(realObject);

        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(realObject));

        consumer(proxy);
        proxy.doSomething();

        Method method = SimpleDynamicProxy.class.getMethod("consumer",Interface.class);
        Method method2 = SimpleDynamicProxy.class.getMethod("consumer",String.class);
        System.out.println("dynamic call method");
        method.invoke(SimpleDynamicProxy.class, new RealObject());
        method2.invoke(SimpleDynamicProxy.class, new String("test"));


    }
}
