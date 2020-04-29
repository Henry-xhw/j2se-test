package com.henry.spring.ioc.overview.dependency.injection;

import com.henry.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class DependencyInjectionOriginDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        // 依赖来源一: 自定义bean
        // 用别名的方式
//        UserRepository up2 = applicationContext.getBean("henry", UserRepository.class);
        UserRepository up = applicationContext.getBean("userRepository", UserRepository.class);
//        System.out.println(up == up2);
//        System.out.println(up);
//        System.out.println(up.getUsers());
//        System.out.println(applicationContext);
        // 依赖来源二: 内建依赖
        //依赖注入
        System.out.println(up.getBeanFactory());
        System.out.println(applicationContext);
        System.out.println(up.getBeanFactory() == applicationContext);

        //会报错，说明up.getBeanFactory()不是一个bean
//        System.out.println(applicationContext.getBean(up.getBeanFactory().getClass()));
//        System.out.println(applicationContext.getBean(DefaultListableBeanFactory.class));

        //会报错，说明up.getBeanFactory()不是一个bean
        //依赖查找
        //依赖查找和依赖注入并不是同源
//        System.out.println(applicationContext.getBean(BeanFactory.class));

//        System.out.println(up.getBeanFactory().getBean("user"));
//        System.out.println(applicationContext.getBean("user"));
//        System.out.println(applicationContext.getBean(BeanFactory.class));
        System.out.println(up.getObjectFactory());
        System.out.println(up.getObjectFactory().getObject());
//        System.out.println(applicationContext.getBean("objectFactory"));
//        System.out.println(up.getObjectFactory()==applicationContext.getBean("objectFactory"));
//        System.out.println(up.getObjectFactory().getObject() == applicationContext);
        // 依赖来源三: 容器内建 bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println(environment);
    }

}
