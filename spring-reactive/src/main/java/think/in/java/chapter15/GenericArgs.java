package think.in.java.chapter15;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:40 2019/3/27
 */
public class GenericArgs {

    public static <T> List<T> makeList(T... args) {
        return Arrays.asList(args);
    }

    public static void main(String[] args) {
        List<String> list = makeList("hello", "world");

        System.out.println(list.toString());
    }
}
