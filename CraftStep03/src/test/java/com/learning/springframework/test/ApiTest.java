package com.learning.springframework.test;

import com.learning.springframework.beans.factory.config.BeanDefinition;
import com.learning.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.learning.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class ApiTest.java
 * @Desc test api
 * @date 2022/11/23 22:31
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
        String testArgs = "instance of zekunzhang";
        UserService userService = (UserService) testBeanFactory.getBean(testBeanName, testArgs);
        userService.queryUser();
    }

    @Test
    public void testCglib() {
        String testArgs = "instance of zekunzhang";
        UserService testUserService = new UserService(testArgs);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{testArgs});
        UserService userService = (UserService) obj;
        System.out.println(userService);    // TODO(zhangzekun) figure out the differences between cglib object and normal object
    }

    @Test
    public void testNewInstance() {
        Assert.assertThrows(InstantiationException.class, UserService.class::newInstance);
    }

    @Test
    public void testConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String testArgs = "instance of zekunzhang";
        UserService testUserService = new UserService(testArgs);

        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance(testArgs);

        Assert.assertEquals(testUserService, userService);
        Assert.assertNotSame(testUserService, userService);
    }

    @Test
    public void testParameterTypes() throws Exception {
        String testArgs = "instance of zekunzhang";
        UserService testUserService = new UserService(testArgs);

        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[0];
        Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance(testArgs);

        Assert.assertEquals(testUserService, userService);
        Assert.assertNotSame(testUserService, userService);
    }

}
