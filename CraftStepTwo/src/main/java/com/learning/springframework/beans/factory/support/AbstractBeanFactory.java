package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.BeansException;
import com.learning.springframework.beans.factory.BeanFactory;
import com.learning.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class AbstractBeanFactory.java
 * @Desc abstract bean factory template
 * @date 2022/11/22 22:56
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * get a bean by name or create one
     *
     * @param name name of bean
     * @return singleton instance of bean
     * @throws BeansException errors when query or create
     */
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        System.out.println("Bean is not defined and then create one");  // for test use
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
