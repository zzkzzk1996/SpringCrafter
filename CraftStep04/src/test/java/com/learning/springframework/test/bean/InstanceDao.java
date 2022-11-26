package com.learning.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class InstanceDao.java
 * @Desc test InstanceDao implementation
 * @date 2022/11/26 16:56
 */
public class InstanceDao {

    private static final Map<String, String> map = new HashMap<>();

    static {
        map.put("test1", "testInstance1");
        map.put("test2", "testInstance2");
        map.put("test3", "testInstance3");
    }

    public String queryInstanceName(String id) {
        return map.getOrDefault(id, "default");
    }
}
