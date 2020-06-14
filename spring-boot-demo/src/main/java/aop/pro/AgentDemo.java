package aop.pro;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:44 2020/6/13
 */
public class AgentDemo {
    public static void main(String[] args) {
        Agent target = new Agent();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AgentDecorator());

        proxyFactory.setTarget(target);

        Agent agent = (Agent) proxyFactory.getProxy();
        target.speak();

        System.out.println("");

        agent.speak();
        agent.speak2();
    }
}
