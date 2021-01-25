package lang;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:25 2021/1/23
 */
public class ObjectTest {

    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());

        synchronized (object) {
            System.out.println(ClassLayout.parseInstance(object).toPrintable());

        }

        System.out.println(String.format("aa_%s",12));
    }
}
