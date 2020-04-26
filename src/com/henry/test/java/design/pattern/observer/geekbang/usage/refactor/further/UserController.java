package com.henry.test.java.design.pattern.observer.geekbang.usage.refactor.further;

import com.henry.test.java.design.pattern.observer.geekbang.usage.origin.UserService;
import com.henry.test.java.design.pattern.observer.geekbang.usage.refactor.RegObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

//第二种实现方式，尽管利用了线程池解决了第一种实现方式的问题，
// 但线程池、异步执行逻辑都耦合在了 register() 函数中，增加了这部分业务代码的维护成本。
public class UserController {

    private UserService userService;
    private List<RegObserver> regObservers = new ArrayList<>();
    private Executor executor;

    public UserController(Executor executor) {
        this.executor = executor;
    }

    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password) {
        // 省略输入参数的校验代码
        // 省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);
        regObservers.forEach(regObserver -> {
            executor.execute(() -> {
                regObserver.handleRegSuccess(userId);
            });
        });

        return userId;
    }


}
