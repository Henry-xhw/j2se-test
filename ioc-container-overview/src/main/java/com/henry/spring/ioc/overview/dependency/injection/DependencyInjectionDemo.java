package com.henry.spring.ioc.overview.dependency.injection;

import com.henry.spring.ioc.overview.annotation.Super;
import com.henry.spring.ioc.overview.domain.User;
import com.henry.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
//        BeanFactory applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        // 依赖来源一: 自定义bean

        UserRepository up2 = applicationContext.getBean("henry", UserRepository.class);
        UserRepository up = applicationContext.getBean("userRepository", UserRepository.class);
        System.out.println(up == up2);
//        System.out.println(up);
//        System.out.println(up.getUsers());
//        System.out.println(applicationContext);
        // 依赖来源二: 内建依赖
//        System.out.println(up.getBeanFactory());
//        System.out.println(applicationContext);
//        System.out.println(up.getBeanFactory() == applicationContext);
//        System.out.println(up.getBeanFactory().getBean("user"));
//        System.out.println(applicationContext.getBean("user"));
//        System.out.println(applicationContext.getBean(BeanFactory.class));
//        System.out.println(up.getObjectFactory());
//        System.out.println(up.getObjectFactory().getObject());
//        System.out.println(applicationContext.getBean("objectFactory"));
//        System.out.println(up.getObjectFactory()==applicationContext.getBean("objectFactory"));
//        System.out.println(up.getObjectFactory().getObject() == applicationContext);
        // 依赖来源三: 容器内建 bean
        Environment environment = applicationContext.getBean(Environment.class);
//        System.out.println(environment);
    }

}
