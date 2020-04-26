package com.henry.test.java.design.pattern.observer.geekbang.usage.refactor.further;

import com.henry.test.java.design.pattern.observer.geekbang.usage.origin.PromotionService;
import com.henry.test.java.design.pattern.observer.geekbang.usage.refactor.RegObserver;

// 第一种实现方式，在每个 handleRegSuccess() 函数中创建一个新的线程执行代码逻辑
// 缺点: 频繁地创建和销毁线程比较耗时，并且并发线程数无法控制，创建过多的线程会导致堆栈溢出。
public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService;

    @Override public void handleRegSuccess(long userId) {
        new Thread(() -> {
           promotionService.issueNewUserExperienceCash(userId);
        }).start();
    }
}
