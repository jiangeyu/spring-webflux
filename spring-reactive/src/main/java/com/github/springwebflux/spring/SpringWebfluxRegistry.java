package com.github.springwebflux.spring;

import lombok.Builder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午2:30 2018/9/28
 * @desc
 */
@Builder
@Data
public class SpringWebfluxRegistry implements InitializingBean,DisposableBean {

   private static final Logger logger = LoggerFactory.getLogger(SpringWebfluxRegistry.class);

    private String ipAddress;

    private String protocol;

    private String echoApiPort;

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    @Override
    public void destroy() throws Exception {
        logger.info("destroy registry");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("SpringWebfluxRegistry after reference property set");
    }
}
