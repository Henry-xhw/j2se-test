package com.henry.spring.ioc.overview.container;

import com.henry.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 AnnotationApplicationContextAsIoCContainerDemo 作为配置类 (configuration class)
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找集合对象
        lookupCollectionByType(applicationContext);
        // 停止应用上下文
        applicationContext.close();
    }

    @Bean
    public User getUser() {
        User user = new User();
        user.setAge(8);
        user.setName("youyou");
        return user;
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
