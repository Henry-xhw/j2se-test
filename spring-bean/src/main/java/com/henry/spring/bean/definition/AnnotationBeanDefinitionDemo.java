package com.henry.spring.bean.definition;

import com.henry.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

// 3. 通过 @Import 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    {
        new Thread(()->{
            System.out.println("anonymous inner class.");
        });
    }

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration class (配置类)
        annotationConfigApplicationContext.register(AnnotationBeanDefinitionDemo.class);

        annotationConfigApplicationContext.refresh();

        // 按照类型依赖查找
        System.out.println("Config 类型的所有 Beans" + annotationConfigApplicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans" + annotationConfigApplicationContext.getBeansOfType(User.class));


        annotationConfigApplicationContext.close();

    }

    // 2. 通过@Component 方式
    @Component("112233") //定义当前类作为 spring bean (组件)
    public static class Config {
        // 1. 通过@Bean 定义方式

        /**
         * 通过 Java 注解的方式，定义了一个 Bean
         */
        @Bean(name = {"henry2", "abcdefg", "oobbee"})
        public User getUser() {
            return User.builder().age(40).name("henry2").build();
        }
    }
}

