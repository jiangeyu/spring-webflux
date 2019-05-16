package com.example.springbootdemo;

import aop.TargetInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"config*","aop*"})
public class SpringBootDemoApplication {

    @Autowired
    static TargetInterface targetInterface;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
        String[] beanNames = context.getBeanNamesForType(Runnable.class);
        Arrays.asList(beanNames).stream().forEach(System.out::println);
        targetInterface.advice("dddd");

    }

}
