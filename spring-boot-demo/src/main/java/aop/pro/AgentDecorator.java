package aop.pro;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:43 2020/6/13
 */
public class AgentDecorator implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("before,");
        Object real = methodInvocation.proceed();
        System.out.print(",after");
        return real;
    }
}
