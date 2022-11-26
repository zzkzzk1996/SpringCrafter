package com.learning.springframework.test;

import com.learning.springframework.beans.PropertyValue;
import com.learning.springframework.beans.PropertyValues;
import com.learning.springframework.beans.factory.config.BeanDefinition;
import com.learning.springframework.beans.factory.config.BeanReference;
import com.learning.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.learning.springframework.test.bean.InstanceDao;
import com.learning.springframework.test.bean.UserService;
import org.junit.Test;


/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class ApiTest.java
 * @Desc test api
 * @date 2022/11/26 16:55
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 1. init BeanFactory api
        DefaultListableBeanFactory testBeanFactory = new DefaultListableBeanFactory();

        // 2. register InstanceDao
        testBeanFactory.registerBeanDefinition("instanceDao", new BeanDefinition(InstanceDao.class));

        // 3. apply properties to UserService
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("instanceId", "test3"));
        propertyValues.addPropertyValue(new PropertyValue("instanceDao", new BeanReference("instanceDao")));

        // 4. register UserService
        String testBeanName = UserService.class.getName();
        BeanDefinition testBeanDefinition = new BeanDefinition(UserService.class, propertyValues);
        testBeanFactory.registerBeanDefinition(testBeanName, testBeanDefinition);

        // 5. get bean instance
        UserService userService = (UserService) testBeanFactory.getBean(testBeanName);
        userService.queryUser();
    }
}
