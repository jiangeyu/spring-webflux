package com.github.springwebflux.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午9:58 2018/9/19
 * @desc
 */
@Aspect
@Service
public class AopCall{

    @Pointcut("execution(* *.joinPoint(..))")
    public void joinPoint() {
        System.out.println("joinPoint execute");
    }

    @Before("joinPoint()")
    public void a() {
        System.out.println("before a");
    }

    @After("joinPoint()")
    public void b() {
        System.out.println("after b");
    }

}
