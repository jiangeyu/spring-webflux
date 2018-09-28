package com.github.springwebflux.spring;

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
public class SpringWebfluxService implements ApplicationContextAware,ApplicationListener {

    private String interfaceName;

    private String ref;

    private String filter;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

    }
}
