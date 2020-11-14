package util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午3:31 2020/11/6
 */
public class StreamTest {

    @Test
    public void mapToLong() {
        // Creating a list of Strings
        List<String> list = Arrays.asList("25", "225", "1000", "20", "15");

        // Using Stream mapToLong(ToLongFunction mapper)
        // and displaying the corresponding LongStream
        list.stream().mapToLong(num -> Long.parseLong(num))
                .peek(t -> System.out.println(Math.sqrt(t)))
                .filter(num -> Math.sqrt(num) / 5 == 3 )
                .forEach(System.out::println);


        System.out.println(System.getProperty("file.encoding"));
    }
}
