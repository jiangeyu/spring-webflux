package com.github.springwebflux.config;

import com.github.springwebflux.handler.TimeHandler;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午5:42 2018/9/18
 * @desc
 */
@SpringBootConfiguration
public class RouterConfig {

//    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/time"), TimeHandler::getTime)
                .andRoute(GET("/date"), TimeHandler::getDate)
                .andRoute(GET("/times"), TimeHandler::sendTimePerSec);
    }


    @Bean
    @Conditional(MyCondition.class)
    public Runnable runnableBean1() {
        return () ->{};
    }

    @Bean
    public Runnable runnableBean2() {
        return () ->{};
    }

    @Bean
    @Conditional(MyCondition.class)
    public Runnable runnableBean3() {
        return () ->{};
    }
}
