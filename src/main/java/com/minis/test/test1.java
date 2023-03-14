package com.minis.test;

import com.minis.ClassPathXmlApplicationContext;
import com.minis.beans.BeansException;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-14 16:53
 **/
public class test1 {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AService aservice = (AService)context.getBean("aservice");
        aservice.sayHello();
    }
}
