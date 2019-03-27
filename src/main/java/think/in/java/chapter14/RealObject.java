package think.in.java.chapter14;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午11:28 2019/3/27
 */
public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void somethingElse(String args) {
        System.out.println(args + " ----something else ");
    }
}
