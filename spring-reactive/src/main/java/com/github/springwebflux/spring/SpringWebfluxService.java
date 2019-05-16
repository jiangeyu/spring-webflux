package com.github.springwebflux.spring;

import lombok.Builder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午2:32 2018/9/28
 * @desc
 */
@Builder
@Data
public class SpringWebfluxService implements ApplicationContextAware, ApplicationListener {

    private static final Logger logger = LoggerFactory.getLogger(SpringWebfluxService.class);

    private String interfaceName;

    private String ref;

    private String filter;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

        logger.info("SpringWebfluxService set application context");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("SpringWebfluxService start application event");
    }
}
