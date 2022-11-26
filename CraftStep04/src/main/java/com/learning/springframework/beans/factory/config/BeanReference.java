package com.learning.springframework.beans.factory.config;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class BeanReference.java
 * @Desc A reference implementation for bean
 * @date 2022/11/26 16:55
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
