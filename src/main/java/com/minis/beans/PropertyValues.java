package com.minis.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-15 14:27
 **/
public class PropertyValues {
    private final List<PropertyValue> propertyValueList;

    public PropertyValues() {
        this.propertyValueList=new ArrayList<>(0);
    }

    public List<PropertyValue> getPropertyValueList(){
        return this.propertyValueList;
    }

    public int size(){
        return this.propertyValueList.size();
    }

    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }

    public void addPropertyValue(String propertyName,Object propertyValue){
        addPropertyValue(new PropertyValue(propertyValue,propertyName));
    }

    public void removePropertyValue(PropertyValue pv){
        this.propertyValueList.remove(pv);
    }

    public void removePropertyValue(String propertyName){
        this.propertyValueList.remove(getPropertyValue(propertyName));
    }
    public PropertyValue[] getPropertyValue(){
        return this.propertyValueList.toArray(new PropertyValue[this.propertyValueList.size()]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv:this.propertyValueList) {
            if (pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }

    public Object get(String propertyName){
        PropertyValue pv = getPropertyValue(propertyName);
        return pv !=null? pv.getValue():null;
    }

    public boolean contains(String propertyName){
        return getPropertyValue(propertyName) !=null;
    }

    public boolean isEmpty(){
        return this.propertyValueList.isEmpty();
    }
}
