package think.in.java.chapter15;

import java.util.Collection;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:59 2019/3/27
 */
public class Generators {

    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int n) {
        collection.add(generator.next());
        return collection;
    }
}
