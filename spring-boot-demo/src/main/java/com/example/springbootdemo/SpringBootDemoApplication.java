package com.example.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"config*"})
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
        String[] beanNames = context.getBeanNamesForType(Runnable.class);
        Arrays.asList(beanNames).stream().forEach(System.out::println);

    }

}
