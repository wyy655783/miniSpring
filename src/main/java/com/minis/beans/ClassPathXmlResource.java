package com.minis.beans;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-14 17:12
 **/
public class ClassPathXmlResource implements Resource{
    Document document;
    Element rootElement;
    Iterator<Element> elementIterator;

    public ClassPathXmlResource(String fileName) {
        SAXReader saxReader = new SAXReader();
        URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
        //将配置文件装载进来，生成一个迭代器，可以用于遍历
        try {
            document = saxReader.read(xmlPath);
            rootElement = document.getRootElement();
            elementIterator=this.rootElement.elementIterator();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean hasNext() {
        return elementIterator.hasNext();
    }

    @Override
    public Object next() {
        return elementIterator.next();
    }
}
