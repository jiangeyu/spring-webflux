package aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午10:47 2018/9/19
 * @desc EnableAspectJAutoProxy true  表示使用cglib代理
 */
@Component("joinPint")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class TargetInterfaceImpl implements TargetInterface {

    @Override
    public void advice() {
        System.out.println(".................");
        ((TargetInterface)AopContext.currentProxy()).advice("call");
//        this.joinPoint("call");
    }

    @Override
    public void advice(String msg) {
        System.out.println(msg);
    }
}
