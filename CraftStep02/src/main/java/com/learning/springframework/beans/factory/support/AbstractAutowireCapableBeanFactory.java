package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.BeansException;
import com.learning.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class AbstractAutowireCapableBeanFactory.java
 * @Desc abstract class which extends AbstractBeanFactory to implement singleton-bean creation process
 * @date 2022/11/22 22:55
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);    // TODO(zhangzekun) could do more to give more info out when error occurs
        }

        registerSingleton(beanName, bean);    // TODO(zhangzekun) how to solve concurrent conflicts
        return bean;
    }
}
