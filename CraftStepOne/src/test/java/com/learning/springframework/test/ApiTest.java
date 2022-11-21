package com.learning.springframework.test;

import com.learning.springframework.BeanDefinition;
import com.learning.springframework.BeanFactory;
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
        // 1. init mock bean factory
        BeanFactory testBeanFactory = new BeanFactory();

        // 2. register mocked bean
        Object testBean = new UserService();
        String testBeanName = testBean.getClass().getName();
        BeanDefinition testBeanDefinition = new BeanDefinition(new UserService());
        testBeanFactory.registerBeanDefinition(testBeanName, testBeanDefinition);

        // 3. get bean object
        UserService userService = (UserService) testBeanFactory.getBean(testBeanName);
        userService.queryUser();
    }

}
