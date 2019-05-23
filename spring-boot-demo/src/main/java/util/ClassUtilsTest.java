package util;

import aop.GrammyGuitarist;
import org.springframework.util.ClassUtils;

import java.util.Arrays;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午10:28 2019/5/23
 */
public class ClassUtilsTest {

    public static void main(String[] args) {

        Class<?>[] interfaces = ClassUtils.getAllInterfaces(new GrammyGuitarist());
        Arrays.stream(interfaces).forEach(in -> System.out.println(in.getName()));

        int count = ClassUtils.getMethodCountForName(GrammyGuitarist.class, "sing");
        System.out.println(count);
    }
}
