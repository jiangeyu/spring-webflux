package util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:46 2020/10/28
 */
public class InterfaceTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

//        IntStream.range(1, 10)
////                .peek(x -> System.out.print("\nA" + x))
////                .limit(3)
////                .peek(x -> System.out.print("B" + x))
////                .forEach(x -> System.out.print("C" + x));
////
////
////        IntStream.range(1, 10)
////                .peek(x -> System.out.print("\nA" + x))
////                .skip(6)
////                .peek(x -> System.out.print("B" + x))
////                .forEach(x -> System.out.print("C" + x));

        BiFunction<String, String, String> bi = (x, y) -> x + y;

        Function<String, String> f = x -> x + " spinner";

        System.out.println(bi.andThen(f).apply("hello", " world"));

        System.out.println(compute(1, 3, (v1, v2) -> v1 + v2, v1 -> v1 * v1));


    }

    public static int compute(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
