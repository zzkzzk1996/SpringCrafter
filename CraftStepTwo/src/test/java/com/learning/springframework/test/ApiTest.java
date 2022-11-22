package com.learning.springframework.test;

import com.learning.springframework.beans.factory.BeanFactory;
import com.learning.springframework.beans.factory.config.BeanDefinition;
import com.learning.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.learning.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import com.learning.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class ApiTest.java
 * @Desc test api
 * @date 2022/11/21 23:29
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 1. init BeanFactory api
        DefaultListableBeanFactory testBeanFactory = new DefaultListableBeanFactory();

        // 2. register bean object
        String testBeanName = UserService.class.getName();
        BeanDefinition testBeanDefinition = new BeanDefinition(UserService.class);
        testBeanFactory.registerBeanDefinition(testBeanName, testBeanDefinition);

        // 3. get bean instance
        UserService userService = (UserService) testBeanFactory.getBean(testBeanName);
        userService.queryUser();

        // 4. get singleton instance
        UserService userServiceSingleton = (UserService) testBeanFactory.getBean(testBeanName);
        userServiceSingleton.queryUser();
    }

}
