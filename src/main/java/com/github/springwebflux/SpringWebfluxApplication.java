package com.github.springwebflux;

import com.github.springwebflux.entity.MyEvent;
import com.github.springwebflux.servlet.MyServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午4:08 2018/9/11
 * @desc
 */

@SpringBootApplication
@ServletComponentScan
@ImportResource(value = {"classpath:application-bean.xml"})
public class SpringWebfluxApplication {

    @Bean
    public ServletRegistrationBean myServlet1() {
        return new ServletRegistrationBean(new MyServlet(),"/myServlet1/*");
    }

    @Bean
    public CommandLineRunner initData(MongoOperations mongo) {
        return (String... args) -> {
            mongo.dropCollection(MyEvent.class);
            mongo.createCollection(MyEvent.class, CollectionOptions.empty().maxDocuments(200).size(1000).capped());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxApplication.class, args);
    }
}
