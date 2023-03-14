package com.minis;

import com.minis.beans.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: miniSpring
 * @description: 读取xml中Bean信息
 * @author: wyh1
 * @create: 2023-03-14 15:09
 **/
public class ClassPathXmlApplicationContext implements BeanFactory {
    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }
//    private List<BeanDefinition> beanDefinitions=new ArrayList<>();
//    private Map<String, Object> singletons= new HashMap<>();
//
//    //构造器获取外部配置，解析Bean的定义，形成内存映像
//    public ClassPathXmlApplicationContext(String fileName) {
//        this.readXml(fileName);
//        this.instanceBeans();
//    }
//
//    private void readXml(String fileName) {
//        SAXReader saxReader = new SAXReader();
//        try {
//            URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
//            Document document = saxReader.read(xmlPath);
//            Element rootElement = document.getRootElement();
//            //对配置文件中的每一个《bean》,进行处理
//            for (Element element:(List<Element>)rootElement.elements()) {
//                //获取bean的基本信息
//                String beanID = element.attributeValue("id");
//                String beanClassName = element.attributeValue("class");
//                BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
//                //将bean的定义信息放到beanDefinitions
//                beanDefinitions.add(beanDefinition);
//            }
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//
//    }
//    //利用反射创建Bean实例，并存储在singletons容器中
//    private void instanceBeans() {
//        for (BeanDefinition beanDefinition:beanDefinitions) {
//            try {
//                singletons.put(beanDefinition.getId(),Class.forName(beanDefinition.getClassName()).newInstance());
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    //提供一个对外方法，让外部程序获取bean实例，逐步演变成核心方法
//    public Object getBean(String beanName){
//        return singletons.get(beanName);
//    }
}
