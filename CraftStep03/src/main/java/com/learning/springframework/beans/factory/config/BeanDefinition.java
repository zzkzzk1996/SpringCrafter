package com.learning.springframework.beans.factory.config;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class BeanDefinition.java
 * @Desc Simple bean class definition
 * @date 2022/11/22 23:02
 */

public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
