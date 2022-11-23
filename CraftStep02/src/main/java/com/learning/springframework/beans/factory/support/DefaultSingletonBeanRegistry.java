package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class DefaultSingletonBeanRegistry.java
 * @Desc
 * @date 2022/11/22 22:56
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();   // TODO(zhangzekun) why not use final and concurrentHashMap

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);  // TODO(zhangzekun) would give a null
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);    // TODO(zhangzekun) how to raise errors when name conflicts and nullable values
    }
}
