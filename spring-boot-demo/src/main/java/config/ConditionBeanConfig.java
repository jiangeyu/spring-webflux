package config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:26 2019/5/15
 */
//@SpringBootConfiguration
//public class ConditionBeanConfig {
//
//    @Bean
//    @Conditional(MyCondition.class)
//    public Runnable runnableBean1() {
//        return () -> System.out.println("bean1");
//    }
//
//    @Bean
//    public Runnable runnableBean2() {
//        return () -> System.out.println("bean1");
//    }
//
//    @Bean
//    @Conditional(MyCondition.class)
//    public Runnable runnableBean3() {
//        return () -> System.out.println("bean1");
//    }
//}
