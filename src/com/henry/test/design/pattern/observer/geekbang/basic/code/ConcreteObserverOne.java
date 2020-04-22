package com.henry.test.design.pattern.observer.geekbang.basic.code;

public class ConcreteObserverOne implements Observer {
    @Override public void update(Message message) {
        //TODO: 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverOne is notified.");
    }
}
