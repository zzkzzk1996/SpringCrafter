package com.learning.springframework.beans.factory.config;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Interface SingletonBeanRegistry.java
 * @date 2022/11/22 23:06
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
