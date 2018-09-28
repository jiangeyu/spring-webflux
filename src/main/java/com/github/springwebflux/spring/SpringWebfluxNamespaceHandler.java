package com.github.springwebflux.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午1:57 2018/9/28
 * @desc
 */
public class SpringWebfluxNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("service", new SpringWebfluxServiceParser());
        registerBeanDefinitionParser("registry", new SpringWebfluxRegistryParser());
        registerBeanDefinitionParser("reference", new SpringWebfluxReferenceParser());
    }
}
