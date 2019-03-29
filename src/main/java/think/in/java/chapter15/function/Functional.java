package think.in.java.chapter15.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:40 2019/3/27
 */
public class Functional {

    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {

        Iterator<T> iterator = seq.iterator();

        if (iterator.hasNext()) {
            T result = iterator.next();
            while (iterator.hasNext()) {
                result = combiner.combine(result, iterator.next());

            }
            return result;
        }

        return null;
    }

    public static <T> Collector<T> foreach(Iterable<T> seq, Collector<T> func) {
        for (T t : seq) {
            func.function(t);
        }
        return func;
    }

    public static <R, T> List<R> transform(Iterable<T> seq, UnaryFunction<R, T> func) {
        List<R> result = new ArrayList<>();
        for (T t : seq) {
            result.add(func.function(t));
        }
        return result;
    }

    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> result = new ArrayList<>();
        for (T t : seq) {
            if (pred.test(t)) {
                result.add(t);

            }
        }
        return result;
    }

    static class IntegerAdder implements Combiner<Integer> {

        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    static class IntegerSubtract implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T>{

        private T bound;

        public GreaterThan(T bound) {
            this.bound = bound;
        }

        @Override
        public boolean test(T x) {
            return x.compareTo(bound) > 0;

        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer result = reduce(list, new IntegerAdder());
        Integer result2 = reduce(list, new IntegerSubtract());
        System.out.println(result);
        System.out.println(result2);

        System.out.println(filter(list, new GreaterThan<>(4)));
    }

}
