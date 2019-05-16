package think.in.java.chapter20;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:21 2019/3/25
 */
public @interface Constraints {

    boolean primaryKey() default false;

    boolean allowNull() default true;

    boolean unique() default false;
}
