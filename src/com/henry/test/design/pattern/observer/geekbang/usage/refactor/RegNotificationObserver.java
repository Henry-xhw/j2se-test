package com.henry.test.design.pattern.observer.geekbang.usage.refactor;

public class RegNotificationObserver implements RegObserver {
    private NotificationService notificationService; //依赖注入
    @Override public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId);
    }
}
