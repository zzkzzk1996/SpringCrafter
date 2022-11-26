package com.learning.springframework.test.bean;

import java.util.Objects;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class UserService.java
 * @Desc test service as a bean
 * @date 2022/11/26 16:55
 */
public class UserService {

    private String instanceId;

    private InstanceDao instanceDao;

    public void queryUser() {
        System.out.println("[" + instanceDao.queryInstanceName(instanceId) + "]" + "query user info triggered");
    }

    @Override
    public String toString() {
        return "UserService{instanceId='" + instanceId + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserService that = (UserService) o;
        return Objects.equals(instanceId, that.instanceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instanceId);
    }
}
