package com.github.springwebflux.spring;

import com.google.common.reflect.AbstractInvocationHandler;
import com.google.common.reflect.Reflection;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.Method;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午2:25 2018/9/28
 * @desc
 */
@Builder
public class SpringWebfluxReference implements FactoryBean, InitializingBean, DisposableBean {

    private static Logger logger = LoggerFactory.getLogger(SpringWebfluxReference.class);

    private String interfaceName;

    private String ipAddress;

    private String protocol;


    @Override
    public void destroy() throws Exception {
        logger.info("destroy reference");
    }

    @Override
    public Object getObject() throws Exception {
        return Reflection.newProxy(getObjectType(), new AbstractInvocationHandler() {
            @Override
            protected Object handleInvocation(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
    }

    @Override
    public Class<?> getObjectType() {
        try {
            return this.getClass().getClassLoader().loadClass(interfaceName);
        } catch (ClassNotFoundException e) {
            logger.error(e.toString());
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("after reference property set");
    }
}
