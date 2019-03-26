package think.in.java.chapter19;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午11:50 2019/3/26
 */
public interface Generator<T> {

     <T> T next();
}
