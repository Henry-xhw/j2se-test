package com.henry.spring.ioc.overview.repository;

import com.henry.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

public class UserRepository {
    private Collection<User> users;
    // 内建 非bean 对象(依赖)
    private BeanFactory beanFactory;
    private ObjectFactory<User> objectFactory;

    @Override public String toString() {
        return "UserRepository{" + "users=" + users + '}';
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<User> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<User> objectFactory) {
        this.objectFactory = objectFactory;
    }
}
