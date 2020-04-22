package com.henry.spring.ioc.overview.container;

import com.henry.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryAsIoCContainerDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        System.out.println(reader.loadBeanDefinitions(location));
        lookupCollectionByType(beanFactory);
    }
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
            //            map.forEach((k, v) -> {
            //                System.out.println("key: " + k + " ; value: " + v);
            //            });
            System.out.println("查找到的所有的 User 集合对象：" + map);
        }
    }
}

