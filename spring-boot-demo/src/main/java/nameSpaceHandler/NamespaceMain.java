package nameSpaceHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:33 2020/6/6
 */
public class NamespaceMain {
    public static void main(String[] args) {
        ApplicationContext df = new ClassPathXmlApplicationContext("META-INF/test.xml");

        User user = (User) df.getBean("userBean");
        System.out.println(user.toString());

    }
}
