package com.github.springwebflux.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午10:47 2018/9/19
 * @desc
 */
@Component("joinPint")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class JoinPointImpl implements JoinPoint {

    @Override
    public void joinPoint() {
        System.out.println(".................");
        ((JoinPoint)AopContext.currentProxy()).joinPoint("call");
//        this.joinPoint("call");
    }

    @Override
    public void joinPoint(String msg) {
        System.out.println(msg);
    }
}
