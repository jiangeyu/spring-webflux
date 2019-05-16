package think.in.java.chapter14;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:15 2019/3/26
 */
public class Shapes {

    public static void main(String[] args) {
        List<Shape> list = Arrays.asList(new Circle(),new Square());
        list.stream().forEach(System.out::println);
    }
}
