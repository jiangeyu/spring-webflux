package think.in.java.chapter15.function;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:23 2019/3/27
 */
public interface UnaryFunction<R, T> {
    R function(T x);
}
