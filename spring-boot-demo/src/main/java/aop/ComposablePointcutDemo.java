package main.java.aop;

import aop.GrammyGuitarist;
import aop.Guitar;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午8:14 2019/5/21
 * @desc
 */
public class ComposablePointcutDemo {

    public static void main(String[] args) {

        GrammyGuitarist joinMayer = new GrammyGuitarist();

        ComposablePointcut cp = new ComposablePointcut(ClassFilter.TRUE, new SingMethodMatcher());

        System.out.println("------test1");

        GrammyGuitarist proxy = getProxy(cp, joinMayer);
        testInvoke(proxy);
        System.out.println();

        System.out.println("------test2");

        cp.union(new TalkMethodMatcher());
        proxy = getProxy(cp, joinMayer);
        testInvoke(proxy);
        System.out.println();

        System.out.println("------test3");

        cp.intersection(new RestMethodMatcher());

        proxy = getProxy(cp, joinMayer);
        testInvoke(proxy);


    }

    private static void testInvoke(GrammyGuitarist proxy) {
        proxy.sing(new Guitar());
        proxy.talk();
        proxy.rest();
    }

    private static GrammyGuitarist getProxy(ComposablePointcut cp, GrammyGuitarist target) {
        Advisor advisor = new DefaultPointcutAdvisor(cp, new main.java.aop.SimpleBeforeAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        return (GrammyGuitarist) pf.getProxy();
    }


    private static class SingMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return method.getName().startsWith("si");
        }
    }

    private static class TalkMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return "talk".equals(method.getName());
        }
    }

    private static class RestMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return method.getName().endsWith("st");
        }
    }

}
