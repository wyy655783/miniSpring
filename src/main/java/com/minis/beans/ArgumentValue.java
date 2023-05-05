package com.minis.beans;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-15 14:22
 **/
public class ArgumentValue {
    private Object value;
    private String name;
    private String type;

    public ArgumentValue(Object value, String type) {
        this.value = value;
        this.type = type;
    }

    public ArgumentValue(Object value, String name, String type) {
        this.value = value;
        this.name = name;
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
