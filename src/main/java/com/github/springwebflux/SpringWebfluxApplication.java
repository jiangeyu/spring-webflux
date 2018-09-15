package com.github.springwebflux;

import com.github.springwebflux.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

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

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxApplication.class, args);
    }
}
