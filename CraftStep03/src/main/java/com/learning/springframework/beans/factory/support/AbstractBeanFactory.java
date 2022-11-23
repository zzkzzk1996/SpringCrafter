package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.BeansException;
import com.learning.springframework.beans.factory.BeanFactory;
import com.learning.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class AbstractBeanFactory.java
 * @Desc abstract bean factory template
 * @date 2022/11/23 22:31
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
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) { // TODO(zhangzekun) why use generic type here
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
