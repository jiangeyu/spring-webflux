package think.in.java.chapter14;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:02 2019/3/26
 */
public class Initable2 {

    static int staticNonFinal = 147;
    static {
        System.out.println("init  Initable2 ");

    }
}
