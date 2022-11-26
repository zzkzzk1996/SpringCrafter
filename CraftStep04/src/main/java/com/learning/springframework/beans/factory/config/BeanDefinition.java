package com.learning.springframework.beans.factory.config;

import com.learning.springframework.beans.PropertyValues;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class BeanDefinition.java
 * @Desc Simple bean class definition
 * @date 2022/11/26 16:55
 */

public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this(beanClass, new PropertyValues());
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
