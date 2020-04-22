package com.henry.test.design.pattern.observer.geekbang.usage.refactor.further.eventbus;

import com.google.common.eventbus.Subscribe;
import com.henry.test.design.pattern.observer.geekbang.usage.origin.PromotionService;
import com.henry.test.design.pattern.observer.geekbang.usage.refactor.RegObserver;

public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService; // 依赖注入

    @Subscribe
    @Override public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
