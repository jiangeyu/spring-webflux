package com.github.springwebflux;

import com.github.springwebflux.aop.JoinPointImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringWebfluxApplicationTests {

    @Autowired
    JoinPointImpl joinPointTest;

    @Test
    public void contextLoads() {
        joinPointTest.joinPoint();
//        joinPointTest.joinPoint("test");
    }

}
