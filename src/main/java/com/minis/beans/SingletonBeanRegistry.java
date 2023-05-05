package com.minis.beans;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-15 11:04
 **/
public interface SingletonBeanRegistry {
    void registerSingleton(String beanName,Object singletonObject);
    Object getSingleton(String beanName);
    boolean containsSingleton(String beanName);
    String[] getSingletonNames();
}
