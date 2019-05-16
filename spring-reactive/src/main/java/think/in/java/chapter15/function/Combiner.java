package think.in.java.chapter15.function;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午6:28 2019/3/27
 */
public interface Combiner<T> {

    T combine(T x, T y);
}
