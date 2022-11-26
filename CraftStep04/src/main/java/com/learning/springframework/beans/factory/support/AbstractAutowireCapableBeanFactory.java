package com.learning.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.learning.springframework.beans.BeansException;
import com.learning.springframework.beans.PropertyValue;
import com.learning.springframework.beans.PropertyValues;
import com.learning.springframework.beans.factory.config.BeanDefinition;
import com.learning.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class AbstractAutowireCapableBeanFactory.java
 * @Desc abstract class which extends AbstractBeanFactory to implement singleton-bean creation process
 * @date 2022/11/26 16:55
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // apply properties for bean
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean '" + beanName + "' failed", e);
        }

        registerSingleton(beanName, bean);    // TODO(zhangzekun) how to solve concurrent conflicts
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            if (null != args && constructor.getParameterTypes().length == args.length) {    // TODO(zhangzekun) how to solve when length is the same and params type is different
                constructorToUse = constructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * apply properties to bean object
     * @param beanName Name of bean
     * @param bean bean object
     * @param beanDefinition {@code BeanDefinition}
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {   // TODO(zhangzekun) need to handle dependency loop
                    // e.g. Bean A has property Bean B, then get the instance of B
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                BeanUtil.setFieldValue(bean, name, value);  // TODO(zhangzekun) can be replaced
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values for: " + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
