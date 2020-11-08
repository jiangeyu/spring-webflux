package util;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:44 2020/10/28
 */
@FunctionalInterface
public interface ReturnIntInterface<T,R> {

    R get(T a);




    default R  getAll(T a) {
       return this.get(a);
    }
}
