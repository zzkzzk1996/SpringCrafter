package com.learning.springframework.beans.factory;

import com.learning.springframework.beans.BeansException;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Interface BeanFactory.java
 * @date 2022/11/23 22:31
 */
public interface BeanFactory {

    /**
     * query a specific bean by name
     *
     * @param name name of bean
     * @return singleton instance of bean
     * @throws BeansException errors when query
     */
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;
}
