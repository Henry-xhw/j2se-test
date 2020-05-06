package com.henry.spring.ioc.overview.container;

import com.henry.spring.ioc.overview.domain.User;
import com.henry.spring.ioc.overview.domain.UserHolder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.annotation.Priority;
import javax.annotation.Resource;
import java.util.Map;

public class AnnotationApplicationContextAsIoCContainerDemo2 {
//    @Autowired
    private  User user;

//    @Autowired //在这个构造器上加@Autowired 会报错，出错在 applicationContext.refresh();
    public AnnotationApplicationContextAsIoCContainerDemo2(User user) {
        this.user = user;
    }

    // 默认的构造子，必须要有，下面的applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo2.class);会用到
    public AnnotationApplicationContextAsIoCContainerDemo2() {

    }


    public String getName() {
        return user.getName();
    }

//    @Autowired(required = false)
//    private User efg;
//
//    @Autowired(required = true)
//    private UserHolder userHolder;
//
//    private UserHolder userHolder2;
//    private UserHolder userHolder3;
//    private UserHolder userHolder4;
//
//    @Autowired
//    public void abcUH(UserHolder userHolder2) {
//        this.userHolder2 = userHolder2;
//    }
//
//    @Resource
//    public void abcUH3(UserHolder userHolder3) {
//        this.userHolder3 = userHolder3;
//    }
//
//    @Resource
//    public void abcUH4(UserHolder userHolder4) {
//        this.userHolder4 = userHolder4;
//    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 AnnotationApplicationContextAsIoCContainerDemo 作为配置类 (configuration class)
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo2.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
//        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找集合对象
//        lookupCollectionByType(applicationContext);

        AnnotationApplicationContextAsIoCContainerDemo2 demo2 = applicationContext.getBean(AnnotationApplicationContextAsIoCContainerDemo2.class);
//        AnnotationApplicationContextAsIoCContainerDemo2 demo22 = new AnnotationApplicationContextAsIoCContainerDemo2(new User(39, "new_new_henry"));
//        System.out.println(demo2.getName());
//        System.out.println(demo22.getName());
//        User abc = demo2.abc;
//        System.out.println(abc == demo2.efg);
//        System.out.println(abc);
//        System.out.println(demo2.user);
//        System.out.println(demo2.userHolder);
//        System.out.println(demo2.userHolder2);
//        System.out.println(demo2.userHolder3);
//        System.out.println(demo2.userHolder4);
//        System.out.println(applicationContext.getBean("getUser2"));
//        System.out.println(applicationContext.getBean("getUser"));

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

    @Primary
    @Bean
    public User getUser2() {
        User user = new User();
        user.setAge(3);
        user.setName("zuozuo");
        return user;
    }

//    @Bean //会产生一个name为"getUser2"的spring bean
    public UserHolder getUser2(User user) {
//        return new UserHolder(new User(39, "new_henry"));
        return new UserHolder(user);
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
