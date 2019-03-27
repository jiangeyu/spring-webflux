package think.in.java.chapter14;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午11:29 2019/3/27
 */
public class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("proxied doSomething");
        proxied.doSomething();

    }

    @Override
    public void somethingElse(String args) {
        System.out.println("proxied doSomething");
        proxied.somethingElse(args);
    }
}
