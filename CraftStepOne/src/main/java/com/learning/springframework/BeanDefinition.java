package com.learning.springframework;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class BeanDefinition.java
 * @Desc Simple bean object
 * @date 2022/11/21 22:47
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
