package com.minis.beans;

import com.minis.BeanDefinition;
import java.util.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-14 17:35
 **/
public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory{
    private Map<String, BeanDefinition> beanDefinitions= new ConcurrentHashMap<>(256);

    public SimpleBeanFactory() {
    }

    //getBean，容器的核心方法
    @Override
    public Object getBean(String beanName) throws BeansException {
        //先尝试直接拿Bean实例
        Object singleton= this.getSingleton(beanName);
        //如果此时还没有这个Bean的实例，则获取它的定义来创建实例
        if (singleton==null){
            BeanDefinition beanDefinition =beanDefinitions.get(beanName);
            if (beanDefinition==null){
                throw new BeansException("NO bean.");
            }
            try {
                singleton=Class.forName(beanDefinition.getClassName()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //
            //注册Bean实例
            this.registerSingleton(beanName,singleton);
        }
        return singleton;
    }

    @Override
    public Boolean containsBean(String name) {
        return containsSingleton(name);
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        this.registerBean(beanName,obj);
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitions.put(beanDefinition.getId(),beanDefinition);
    }
}
