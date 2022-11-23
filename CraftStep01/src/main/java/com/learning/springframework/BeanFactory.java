package com.learning.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class BeanFactory.java
 * @Desc Simple bean factory implemented
 * @date 2022/11/21 22:48
 */
public class BeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();    // TODO(zhangzekun) checkout is there a final keyword

    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();   // TODO(zhangzekun) would cause a NPE here
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);    // TODO(zhangzekun) how to raise errors when name conflicts
    }
}
