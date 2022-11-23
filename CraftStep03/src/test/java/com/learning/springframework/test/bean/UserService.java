package com.learning.springframework.test.bean;

import java.util.Objects;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class UserService.java
 * @Desc test service as a bean
 * @date 2022/11/23 22:31
 */
public class UserService {

    private String instanceName;

    public UserService(String instanceName) {
        this.instanceName = instanceName;
    }

    public void queryUser() {
        System.out.println("[" + instanceName + "]" + "query user info triggered");
    }

    @Override
    public String toString() {
        return "UserService{instanceName='" + instanceName + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserService that = (UserService) o;
        return Objects.equals(instanceName, that.instanceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instanceName);
    }
}
