package com.minis.beans;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-15 14:25
 **/
public class PropertyValue {
    private final Object value;
    private final String name;

    public PropertyValue(Object value, String name) {
        this.value = value;
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
