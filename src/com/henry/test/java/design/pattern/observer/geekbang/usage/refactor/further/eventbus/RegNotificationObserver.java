package com.henry.test.java.design.pattern.observer.geekbang.usage.refactor.further.eventbus;

import com.google.common.eventbus.Subscribe;
import com.henry.test.java.design.pattern.observer.geekbang.usage.refactor.NotificationService;
import com.henry.test.java.design.pattern.observer.geekbang.usage.refactor.RegObserver;

public class RegNotificationObserver implements RegObserver {

    private NotificationService notificationService;

    @Subscribe
    @Override public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId);
    }
}
