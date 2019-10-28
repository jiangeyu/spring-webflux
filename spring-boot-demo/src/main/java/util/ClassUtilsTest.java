package util;

import aop.GrammyGuitarist;
import org.springframework.util.ClassUtils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午10:28 2019/5/23
 */
public class ClassUtilsTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

        Class<?>[] interfaces = ClassUtils.getAllInterfaces(new GrammyGuitarist());
        Arrays.stream(interfaces).forEach(in -> System.out.println(in.getName()));

        int count = ClassUtils.getMethodCountForName(GrammyGuitarist.class, "sing");
        System.out.println(count);

        String str1 = new String("env".getBytes(),"GB18030");
        String str2 = new String(str1.getBytes(),"UTF-8");
        System.out.println(str2);

    }
}
