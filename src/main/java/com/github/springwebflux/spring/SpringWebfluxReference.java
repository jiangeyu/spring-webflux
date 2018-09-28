package com.github.springwebflux.spring;

import com.google.common.eventbus.EventBus;
import lombok.Builder;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午2:25 2018/9/28
 * @desc
 */
@Builder
public class SpringWebfluxReference implements FactoryBean,InitializingBean,DisposableBean {

    private String interfaceName;

    private String ipAddress;

    private String protocol;

    private EventBus eventBus = new EventBus();


    @Override
    public void destroy() throws Exception {

    }

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
