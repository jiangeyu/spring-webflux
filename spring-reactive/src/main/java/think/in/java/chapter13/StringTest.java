package think.in.java.chapter13;

import com.google.common.base.Splitter;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:03 2019/3/27
 */
public class StringTest {

    public static void test()  {

        int n = 1;
        int m = 0;
        double t = n / m;

//        try {
//            int n = 1;
//            int m = 0;
//            double t = n / m;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {

        String route = "/2/3/4";
        List<String> routes = Arrays.asList(route.split("\\/"));
        List<String> routes1 = Splitter.onPattern("/").omitEmptyStrings().splitToList(route);
        routes.stream().forEach(System.out::println);
        System.out.println("------");
        routes1.stream().forEach(System.out::println);

        Long l = new Long(2);
        System.out.println(routes1.contains(l.toString()));

    }
}
