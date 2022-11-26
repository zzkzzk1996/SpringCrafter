package com.learning.springframework.beans.factory.config;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Interface SingletonBeanRegistry.java
 * @date 2022/11/26 16:55
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
