package think.in.java.chapter14;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:04 2019/3/26
 */
public class Initialization2 {

    static int staticNonFinal2 = 147;
    static {
        System.out.println("init  staticNonFinal2 " + staticNonFinal2);

    }
}
