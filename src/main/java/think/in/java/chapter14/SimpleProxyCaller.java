package think.in.java.chapter14;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午11:32 2019/3/27
 */
public class SimpleProxyCaller {

    public static void comsumer(Interface in) {
        in.doSomething();
        in.somethingElse("apple");
    }

    public static void main(String[] args) {
        comsumer(new RealObject());
        comsumer(new SimpleProxy(new RealObject()));
    }
}
