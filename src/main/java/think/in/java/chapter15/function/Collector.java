package think.in.java.chapter15.function;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:24 2019/3/27
 */
public interface Collector<T> extends UnaryFunction<T, T> {
    T result();
}
