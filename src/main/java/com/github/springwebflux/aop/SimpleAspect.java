package com.github.springwebflux.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午9:58 2018/9/19
 * @desc
 */
@Aspect
@Service
public class SimpleAspect {

    @Pointcut("execution(* *.advice(..))")
    public void advice() {
        System.out.println("joinPoint execute");
    }

    @Before("advice()")
    public void before() {
        System.out.println("before a");
    }

    @After("advice()")
    public void after() {
        System.out.println("after b");
    }

    @Around("advice()")
    public void around(ProceedingJoinPoint p) throws Throwable {

        p.proceed();

        System.out.println("around");


    }

}
