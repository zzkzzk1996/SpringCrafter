package com.learning.springframework.beans;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class PropertyValues.java
 * @Desc Collections for PropertyValue
 * @date 2022/11/26 16:56
 */

public class PropertyValues implements Iterable<PropertyValue> {

    private final List<PropertyValue> propertyValues = Lists.newArrayList();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValues.add(propertyValue); // TODO(zhangzekun) null value check
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValues.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {    // TODO(zhangzekun) caution NPE
        for (PropertyValue propertyValue : this.propertyValues) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }

    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValues.iterator();
    }

    @Override
    public void forEach(Consumer<? super PropertyValue> action) {
        propertyValues.forEach(action);
    }

    @Override
    public Spliterator<PropertyValue> spliterator() {
        return propertyValues.spliterator();
    }
}
