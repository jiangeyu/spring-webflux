package lang.reflect;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:49 2021/1/27
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE) // 只保留到编译阶段
@Target(ElementType.TYPE) // 可用于类, 接口..
public @interface MyAnnotation {
}