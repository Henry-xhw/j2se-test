package com.henry.spring.ioc.overview.dependency.lookup;

import com.henry.spring.ioc.overview.annotation.Super;
import com.henry.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        // 按照类型查找
        lookupByTye(beanFactory);
        // 按照类型查找集合对象
        lookupCollectionByType(beanFactory);

//        lookupInRealTime(beanFactory);
//        lookupInLazy(beanFactory);
        // 通过注解查找对象
        lookupByAnnotationType(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> map = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
//            map.forEach((k, v) ->
//                System.out.println("key: " + k + " ; value: " + v)
//            );
            System.out.println("查找标注 @Super 所有的 User 集合对象：" + map);
        }
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

    private static void lookupByTye(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("real time lookup: " + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("real time lookup: " + user);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> of = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = of.getObject();
        System.out.println("lazy lookup: " + user);

    }
}
