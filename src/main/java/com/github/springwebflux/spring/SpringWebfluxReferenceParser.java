package com.github.springwebflux.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午2:34 2018/9/28
 * @desc
 */
public class SpringWebfluxReferenceParser implements BeanDefinitionParser {


    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String interfaceName = element.getAttribute("interfaceName");
        String id = element.getAttribute("id");
        String ipAddress = element.getAttribute("ipAddress");
        String protocolType = element.getAttribute("protocol");

        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(SpringWebfluxReference.class);
        beanDefinition.setLazyInit(false);

        beanDefinition.getPropertyValues().addPropertyValue("interfaceName", interfaceName);
        beanDefinition.getPropertyValues().addPropertyValue("ipAddress", ipAddress);
        beanDefinition.getPropertyValues().addPropertyValue("protocol", protocolType);

        parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);
        return beanDefinition;
    }
}
