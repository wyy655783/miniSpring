package com.minis.beans;

import com.minis.BeanDefinition;
import org.dom4j.Element;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-14 17:23
 **/
public class XmlBeanDefinitionReader {
    SimpleBeanFactory simpleBeanFactory;

    public XmlBeanDefinitionReader(SimpleBeanFactory simpleBeanFactory) {
        this.simpleBeanFactory = simpleBeanFactory;
    }

    public void loadBeanDefinitions(Resource resource){
        while (resource.hasNext()){
            Element element=(Element)resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            //将bean的定义信息放到beanDefinitions
            this.simpleBeanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
