package com.henry.test.java.design.pattern.observer.geekbang.usage.refactor.further.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.henry.test.java.design.pattern.observer.geekbang.usage.origin.UserService;
import com.henry.test.java.design.pattern.observer.geekbang.usage.refactor.RegObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class UserController {

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;
    private List<RegObserver> regObservers = new ArrayList<>();

    private UserService userService; // 依赖注入

    private EventBus eventBus;

    public UserController() {
        // eventBus = new EventBus(); //同步阻塞模式
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));//异步非阻塞模式
    }

    public void setRegObservers(List<RegObserver> observers) {
        observers.forEach(regObserver -> {
            eventBus.register(regObserver);
        });
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);

        eventBus.post(userId);

        return userId;
    }


}
