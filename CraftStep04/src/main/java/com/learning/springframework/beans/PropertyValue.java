package com.learning.springframework.beans;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class PropertyValue.java
 * @Desc Bean Property Implement
 * @date 2022/11/26 16:56
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
