package com.minis.beans;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-14 17:06
 **/
public class BeansException  extends  Exception{
    public BeansException(String msg){
        super(msg);
    }

    public BeansException(){
        super();
    }
}
