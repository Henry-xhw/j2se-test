package com.active.henry.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicProxy {
    public static  void main (String[] args) {
        com.active.henry.java.HelloImpl hello = new com.active.henry.java.HelloImpl();
        com.active.henry.java.MyInvocationHandler handler = new com.active.henry.java.MyInvocationHandler(hello);
        // 构造代码实例
        com.active.henry.java.Hello
            proxyHello = (com.active.henry.java.Hello) Proxy.newProxyInstance(com.active.henry.java.HelloImpl.class.getClassLoader(), com.active.henry.java.HelloImpl.class.getInterfaces(), handler);
        // 调用代理方法
        proxyHello.sayHello();
    }
}

interface Hello {
    void sayHello();
}

class HelloImpl implements com.active.henry.java.Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("Invoking sayHello");
        Object result = method.invoke(target, args);
        return result;
    }
}
