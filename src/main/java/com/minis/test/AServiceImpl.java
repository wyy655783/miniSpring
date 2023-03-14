package com.minis.test;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-14 16:51
 **/
public class AServiceImpl implements AService{
    @Override
    public void sayHello() {
        System.out.println("a service 1 say hello");
    }
}
