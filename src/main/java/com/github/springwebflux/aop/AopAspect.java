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
public class AopAspect {

    @Pointcut("execution(* *.joinPoint(..))")
    public void joinPoint() {
        System.out.println("joinPoint execute");
    }

    @Before("joinPoint()")
    public void before() {
        System.out.println("before a");
    }

    @After("joinPoint()")
    public void after() {
        System.out.println("after b");
    }

    @Around("joinPoint()")
    public void around(ProceedingJoinPoint p) throws Throwable {

        p.proceed();

        System.out.println("around");


    }

}
