import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import scope.Prototype;
import scope.Scope;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:54 2019/7/1
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-singleton.xml");
        ((ClassPathXmlApplicationContext) ctx).refresh();
        Scope scope = (Scope) ctx.getBean("scopeTest");
        Scope scope2 = (Scope) ctx.getBean("scopeTest");
        Scope scopeTestDuplicate = (Scope) ctx.getBean("scopeTestDuplicate");

        System.out.println(scope == scope2);
        System.out.println(scope == scopeTestDuplicate);
        System.out.println(scope + "::" + scopeTestDuplicate);
        System.out.println("----");

        Prototype prototype = (Prototype) ctx.getBean("prototype");
        Prototype prototype2 = (Prototype) ctx.getBean("prototype");
        System.out.println(prototype==prototype2);



    }
}
