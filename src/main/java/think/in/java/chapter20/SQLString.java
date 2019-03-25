package think.in.java.chapter20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:28 2019/3/25
 */

@Target(ElementType.FIELD)
@Retention()
public @interface SQLString {
}
