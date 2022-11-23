package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Interface BeanDefinitionRegistry.java
 * @date 2022/11/22 22:56
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
